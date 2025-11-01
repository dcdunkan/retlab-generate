package in.etuwa.app.ui.leave.duty.proof;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.DialogDutyLeaveBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.leave.duty.DutyLeaveFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ProofDutyLeave.kt */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010\u001f\u001a\u00020\u001eH\u0014J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\"\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u001e2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020\u001eH\u0016J\b\u00105\u001a\u00020\u001eH\u0016J\u0010\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u000208H\u0016J\u001a\u00109\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u0010;\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020<J\b\u0010=\u001a\u00020\u001eH\u0015J\b\u0010>\u001a\u00020\u001eH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001b¨\u0006A"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogDutyLeaveBinding;", "adapter", "Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeaveAdapter;", "getAdapter", "()Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeaveAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "appDates", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogDutyLeaveBinding;", "id", "leaveList", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave$AddLeaveCallBack;", "pickFile", "Ljava/io/File;", "proofDutyLeaveViewModel", "Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeaveViewModel;", "getProofDutyLeaveViewModel", "()Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeaveViewModel;", "proofDutyLeaveViewModel$delegate", "checkbox", "", "hideProgress", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setAddLeaveCallBack", "Lin/etuwa/app/ui/leave/duty/DutyLeaveFragment;", "setUp", "showProgress", "AddLeaveCallBack", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProofDutyLeave extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogDutyLeaveBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<String> appDates;
    private String id;
    private final ArrayList<String> leaveList;
    private AddLeaveCallBack listener;
    private File pickFile;

    /* renamed from: proofDutyLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy proofDutyLeaveViewModel;

    /* compiled from: ProofDutyLeave.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave$AddLeaveCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddLeaveCallBack {
        void onDismiss();
    }

    /* compiled from: ProofDutyLeave.kt */
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

    public ProofDutyLeave() {
        final ProofDutyLeave proofDutyLeave = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(proofDutyLeave);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.proofDutyLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(proofDutyLeave, Reflection.getOrCreateKotlinClass(ProofDutyLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ProofDutyLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ProofDutyLeave proofDutyLeave2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ProofDutyLeaveAdapter>() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.leave.duty.proof.ProofDutyLeaveAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final ProofDutyLeaveAdapter invoke() {
                ComponentCallbacks componentCallbacks = proofDutyLeave2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(ProofDutyLeaveAdapter.class), b2, b3);
            }
        });
        this.leaveList = CollectionsKt.arrayListOf("1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4");
    }

    private final ProofDutyLeaveViewModel getProofDutyLeaveViewModel() {
        return (ProofDutyLeaveViewModel) this.proofDutyLeaveViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogDutyLeaveBinding get_binding() {
        return this._binding;
    }

    private final ProofDutyLeaveAdapter getAdapter() {
        return (ProofDutyLeaveAdapter) this.adapter.getValue();
    }

    /* compiled from: ProofDutyLeave.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/duty/proof/ProofDutyLeave;", "id", "", "appDates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ProofDutyLeave newInstance(String id, ArrayList<String> appDates) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(appDates, "appDates");
            ProofDutyLeave proofDutyLeave = new ProofDutyLeave();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putStringArrayList(ProofDutyLeaveKt.APP_DATES, appDates);
            proofDutyLeave.setArguments(bundle);
            return proofDutyLeave;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.id = arguments.getString("id");
            } catch (NullPointerException unused) {
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogDutyLeaveBinding.inflate(inflater, container, false);
        DialogDutyLeaveBinding dialogDutyLeaveBinding = get_binding();
        if (dialogDutyLeaveBinding != null) {
            dialogDutyLeaveBinding.setProofDutyLeaveViewModel(getProofDutyLeaveViewModel());
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding2 = get_binding();
        if (dialogDutyLeaveBinding2 != null) {
            dialogDutyLeaveBinding2.setLifecycleOwner(this);
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding3 = get_binding();
        if (dialogDutyLeaveBinding3 != null) {
            return dialogDutyLeaveBinding3.getRoot();
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
        LinearLayout linearLayout;
        TextView textView;
        TextView textView2;
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        CheckBox checkBox7;
        CheckBox checkBox8;
        CheckBox checkBox9;
        CheckBox checkBox10;
        ArrayList<String> arrayList = this.appDates;
        if (!(arrayList != null && arrayList.size() == 0)) {
            ArrayList<String> arrayList2 = this.appDates;
            if (arrayList2 != null && arrayList2.size() == 1) {
                DialogDutyLeaveBinding dialogDutyLeaveBinding = get_binding();
                TextView textView3 = dialogDutyLeaveBinding != null ? dialogDutyLeaveBinding.date1 : null;
                if (textView3 != null) {
                    ArrayList<String> arrayList3 = this.appDates;
                    textView3.setText(arrayList3 != null ? arrayList3.get(0) : null);
                }
            } else {
                ArrayList<String> arrayList4 = this.appDates;
                if (arrayList4 != null && arrayList4.size() == 2) {
                    DialogDutyLeaveBinding dialogDutyLeaveBinding2 = get_binding();
                    TextView textView4 = dialogDutyLeaveBinding2 != null ? dialogDutyLeaveBinding2.date1 : null;
                    if (textView4 != null) {
                        ArrayList<String> arrayList5 = this.appDates;
                        textView4.setText(arrayList5 != null ? arrayList5.get(0) : null);
                    }
                    DialogDutyLeaveBinding dialogDutyLeaveBinding3 = get_binding();
                    TextView textView5 = dialogDutyLeaveBinding3 != null ? dialogDutyLeaveBinding3.date2 : null;
                    if (textView5 != null) {
                        ArrayList<String> arrayList6 = this.appDates;
                        textView5.setText(arrayList6 != null ? arrayList6.get(1) : null);
                    }
                } else {
                    ArrayList<String> arrayList7 = this.appDates;
                    if (arrayList7 != null && arrayList7.size() == 3) {
                        DialogDutyLeaveBinding dialogDutyLeaveBinding4 = get_binding();
                        TextView textView6 = dialogDutyLeaveBinding4 != null ? dialogDutyLeaveBinding4.date1 : null;
                        if (textView6 != null) {
                            ArrayList<String> arrayList8 = this.appDates;
                            textView6.setText(arrayList8 != null ? arrayList8.get(0) : null);
                        }
                        DialogDutyLeaveBinding dialogDutyLeaveBinding5 = get_binding();
                        TextView textView7 = dialogDutyLeaveBinding5 != null ? dialogDutyLeaveBinding5.date2 : null;
                        if (textView7 != null) {
                            ArrayList<String> arrayList9 = this.appDates;
                            textView7.setText(arrayList9 != null ? arrayList9.get(1) : null);
                        }
                        DialogDutyLeaveBinding dialogDutyLeaveBinding6 = get_binding();
                        TextView textView8 = dialogDutyLeaveBinding6 != null ? dialogDutyLeaveBinding6.date3 : null;
                        if (textView8 != null) {
                            ArrayList<String> arrayList10 = this.appDates;
                            textView8.setText(arrayList10 != null ? arrayList10.get(2) : null);
                        }
                    } else {
                        ArrayList<String> arrayList11 = this.appDates;
                        if (arrayList11 != null && arrayList11.size() == 4) {
                            DialogDutyLeaveBinding dialogDutyLeaveBinding7 = get_binding();
                            TextView textView9 = dialogDutyLeaveBinding7 != null ? dialogDutyLeaveBinding7.date1 : null;
                            if (textView9 != null) {
                                ArrayList<String> arrayList12 = this.appDates;
                                textView9.setText(arrayList12 != null ? arrayList12.get(0) : null);
                            }
                            DialogDutyLeaveBinding dialogDutyLeaveBinding8 = get_binding();
                            TextView textView10 = dialogDutyLeaveBinding8 != null ? dialogDutyLeaveBinding8.date2 : null;
                            if (textView10 != null) {
                                ArrayList<String> arrayList13 = this.appDates;
                                textView10.setText(arrayList13 != null ? arrayList13.get(1) : null);
                            }
                            DialogDutyLeaveBinding dialogDutyLeaveBinding9 = get_binding();
                            TextView textView11 = dialogDutyLeaveBinding9 != null ? dialogDutyLeaveBinding9.date3 : null;
                            if (textView11 != null) {
                                ArrayList<String> arrayList14 = this.appDates;
                                textView11.setText(arrayList14 != null ? arrayList14.get(2) : null);
                            }
                            DialogDutyLeaveBinding dialogDutyLeaveBinding10 = get_binding();
                            TextView textView12 = dialogDutyLeaveBinding10 != null ? dialogDutyLeaveBinding10.date4 : null;
                            if (textView12 != null) {
                                ArrayList<String> arrayList15 = this.appDates;
                                textView12.setText(arrayList15 != null ? arrayList15.get(3) : null);
                            }
                        } else {
                            ArrayList<String> arrayList16 = this.appDates;
                            if (arrayList16 != null && arrayList16.size() == 5) {
                                DialogDutyLeaveBinding dialogDutyLeaveBinding11 = get_binding();
                                TextView textView13 = dialogDutyLeaveBinding11 != null ? dialogDutyLeaveBinding11.date1 : null;
                                if (textView13 != null) {
                                    ArrayList<String> arrayList17 = this.appDates;
                                    textView13.setText(arrayList17 != null ? arrayList17.get(4) : null);
                                }
                            } else {
                                ArrayList<String> arrayList18 = this.appDates;
                                if (arrayList18 != null && arrayList18.size() == 6) {
                                    DialogDutyLeaveBinding dialogDutyLeaveBinding12 = get_binding();
                                    TextView textView14 = dialogDutyLeaveBinding12 != null ? dialogDutyLeaveBinding12.date1 : null;
                                    if (textView14 != null) {
                                        ArrayList<String> arrayList19 = this.appDates;
                                        textView14.setText(arrayList19 != null ? arrayList19.get(5) : null);
                                    }
                                } else {
                                    ArrayList<String> arrayList20 = this.appDates;
                                    if (arrayList20 != null && arrayList20.size() == 7) {
                                        DialogDutyLeaveBinding dialogDutyLeaveBinding13 = get_binding();
                                        TextView textView15 = dialogDutyLeaveBinding13 != null ? dialogDutyLeaveBinding13.date1 : null;
                                        if (textView15 != null) {
                                            ArrayList<String> arrayList21 = this.appDates;
                                            textView15.setText(arrayList21 != null ? arrayList21.get(6) : null);
                                        }
                                    } else {
                                        ArrayList<String> arrayList22 = this.appDates;
                                        if (arrayList22 != null && arrayList22.size() == 8) {
                                            DialogDutyLeaveBinding dialogDutyLeaveBinding14 = get_binding();
                                            TextView textView16 = dialogDutyLeaveBinding14 != null ? dialogDutyLeaveBinding14.date1 : null;
                                            if (textView16 != null) {
                                                ArrayList<String> arrayList23 = this.appDates;
                                                textView16.setText(arrayList23 != null ? arrayList23.get(7) : null);
                                            }
                                        } else {
                                            ArrayList<String> arrayList24 = this.appDates;
                                            if (arrayList24 != null && arrayList24.size() == 9) {
                                                DialogDutyLeaveBinding dialogDutyLeaveBinding15 = get_binding();
                                                TextView textView17 = dialogDutyLeaveBinding15 != null ? dialogDutyLeaveBinding15.date1 : null;
                                                if (textView17 != null) {
                                                    ArrayList<String> arrayList25 = this.appDates;
                                                    textView17.setText(arrayList25 != null ? arrayList25.get(0) : null);
                                                }
                                            } else {
                                                ArrayList<String> arrayList26 = this.appDates;
                                                if (arrayList26 != null && arrayList26.size() == 10) {
                                                    DialogDutyLeaveBinding dialogDutyLeaveBinding16 = get_binding();
                                                    TextView textView18 = dialogDutyLeaveBinding16 != null ? dialogDutyLeaveBinding16.date1 : null;
                                                    if (textView18 != null) {
                                                        ArrayList<String> arrayList27 = this.appDates;
                                                        textView18.setText(arrayList27 != null ? arrayList27.get(0) : null);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        listenResponse();
        listenProgressResponse();
        DialogDutyLeaveBinding dialogDutyLeaveBinding17 = get_binding();
        if (dialogDutyLeaveBinding17 != null && (checkBox10 = dialogDutyLeaveBinding17.checkBoxOne) != null) {
            checkBox10.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$1(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding18 = get_binding();
        if (dialogDutyLeaveBinding18 != null && (checkBox9 = dialogDutyLeaveBinding18.checkBoxTwo) != null) {
            checkBox9.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$2(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding19 = get_binding();
        if (dialogDutyLeaveBinding19 != null && (checkBox8 = dialogDutyLeaveBinding19.checkBoxThree) != null) {
            checkBox8.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$3(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding20 = get_binding();
        if (dialogDutyLeaveBinding20 != null && (checkBox7 = dialogDutyLeaveBinding20.checkBoxFour) != null) {
            checkBox7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$4(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding21 = get_binding();
        if (dialogDutyLeaveBinding21 != null && (checkBox6 = dialogDutyLeaveBinding21.checkBoxFive) != null) {
            checkBox6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$5(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding22 = get_binding();
        if (dialogDutyLeaveBinding22 != null && (checkBox5 = dialogDutyLeaveBinding22.checkBoxSix) != null) {
            checkBox5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$6(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding23 = get_binding();
        if (dialogDutyLeaveBinding23 != null && (checkBox4 = dialogDutyLeaveBinding23.checkBoxSeven) != null) {
            checkBox4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$7(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding24 = get_binding();
        if (dialogDutyLeaveBinding24 != null && (checkBox3 = dialogDutyLeaveBinding24.checkBoxEight) != null) {
            checkBox3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$8(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding25 = get_binding();
        if (dialogDutyLeaveBinding25 != null && (checkBox2 = dialogDutyLeaveBinding25.checkBoxNine) != null) {
            checkBox2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$9(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding26 = get_binding();
        if (dialogDutyLeaveBinding26 != null && (checkBox = dialogDutyLeaveBinding26.checkBoxTen) != null) {
            checkBox.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$10(ProofDutyLeave.this, view);
                }
            });
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding27 = get_binding();
        if (dialogDutyLeaveBinding27 != null && (textView2 = dialogDutyLeaveBinding27.dutySelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProofDutyLeave.setUp$lambda$12(ProofDutyLeave.this, view);
                }
            });
        }
        ArrayList<String> arrayList28 = this.appDates;
        Integer valueOf = arrayList28 != null ? Integer.valueOf(arrayList28.size()) : null;
        System.out.println(valueOf);
        if (valueOf != null && valueOf.intValue() == 1) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding28 = get_binding();
            linearLayout = dialogDutyLeaveBinding28 != null ? dialogDutyLeaveBinding28.datelt1 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 2) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding29 = get_binding();
            LinearLayout linearLayout2 = dialogDutyLeaveBinding29 != null ? dialogDutyLeaveBinding29.datelt1 : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding30 = get_binding();
            linearLayout = dialogDutyLeaveBinding30 != null ? dialogDutyLeaveBinding30.datelt2 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 3) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding31 = get_binding();
            LinearLayout linearLayout3 = dialogDutyLeaveBinding31 != null ? dialogDutyLeaveBinding31.datelt1 : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding32 = get_binding();
            LinearLayout linearLayout4 = dialogDutyLeaveBinding32 != null ? dialogDutyLeaveBinding32.datelt2 : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding33 = get_binding();
            linearLayout = dialogDutyLeaveBinding33 != null ? dialogDutyLeaveBinding33.datelt3 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 4) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding34 = get_binding();
            LinearLayout linearLayout5 = dialogDutyLeaveBinding34 != null ? dialogDutyLeaveBinding34.datelt1 : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding35 = get_binding();
            LinearLayout linearLayout6 = dialogDutyLeaveBinding35 != null ? dialogDutyLeaveBinding35.datelt2 : null;
            if (linearLayout6 != null) {
                linearLayout6.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding36 = get_binding();
            LinearLayout linearLayout7 = dialogDutyLeaveBinding36 != null ? dialogDutyLeaveBinding36.datelt3 : null;
            if (linearLayout7 != null) {
                linearLayout7.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding37 = get_binding();
            linearLayout = dialogDutyLeaveBinding37 != null ? dialogDutyLeaveBinding37.datelt4 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 5) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding38 = get_binding();
            LinearLayout linearLayout8 = dialogDutyLeaveBinding38 != null ? dialogDutyLeaveBinding38.datelt1 : null;
            if (linearLayout8 != null) {
                linearLayout8.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding39 = get_binding();
            LinearLayout linearLayout9 = dialogDutyLeaveBinding39 != null ? dialogDutyLeaveBinding39.datelt2 : null;
            if (linearLayout9 != null) {
                linearLayout9.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding40 = get_binding();
            LinearLayout linearLayout10 = dialogDutyLeaveBinding40 != null ? dialogDutyLeaveBinding40.datelt3 : null;
            if (linearLayout10 != null) {
                linearLayout10.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding41 = get_binding();
            LinearLayout linearLayout11 = dialogDutyLeaveBinding41 != null ? dialogDutyLeaveBinding41.datelt4 : null;
            if (linearLayout11 != null) {
                linearLayout11.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding42 = get_binding();
            linearLayout = dialogDutyLeaveBinding42 != null ? dialogDutyLeaveBinding42.datelt5 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 6) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding43 = get_binding();
            LinearLayout linearLayout12 = dialogDutyLeaveBinding43 != null ? dialogDutyLeaveBinding43.datelt1 : null;
            if (linearLayout12 != null) {
                linearLayout12.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding44 = get_binding();
            LinearLayout linearLayout13 = dialogDutyLeaveBinding44 != null ? dialogDutyLeaveBinding44.datelt2 : null;
            if (linearLayout13 != null) {
                linearLayout13.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding45 = get_binding();
            LinearLayout linearLayout14 = dialogDutyLeaveBinding45 != null ? dialogDutyLeaveBinding45.datelt3 : null;
            if (linearLayout14 != null) {
                linearLayout14.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding46 = get_binding();
            LinearLayout linearLayout15 = dialogDutyLeaveBinding46 != null ? dialogDutyLeaveBinding46.datelt4 : null;
            if (linearLayout15 != null) {
                linearLayout15.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding47 = get_binding();
            LinearLayout linearLayout16 = dialogDutyLeaveBinding47 != null ? dialogDutyLeaveBinding47.datelt5 : null;
            if (linearLayout16 != null) {
                linearLayout16.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding48 = get_binding();
            linearLayout = dialogDutyLeaveBinding48 != null ? dialogDutyLeaveBinding48.datelt6 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 7) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding49 = get_binding();
            LinearLayout linearLayout17 = dialogDutyLeaveBinding49 != null ? dialogDutyLeaveBinding49.datelt1 : null;
            if (linearLayout17 != null) {
                linearLayout17.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding50 = get_binding();
            LinearLayout linearLayout18 = dialogDutyLeaveBinding50 != null ? dialogDutyLeaveBinding50.datelt2 : null;
            if (linearLayout18 != null) {
                linearLayout18.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding51 = get_binding();
            LinearLayout linearLayout19 = dialogDutyLeaveBinding51 != null ? dialogDutyLeaveBinding51.datelt3 : null;
            if (linearLayout19 != null) {
                linearLayout19.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding52 = get_binding();
            LinearLayout linearLayout20 = dialogDutyLeaveBinding52 != null ? dialogDutyLeaveBinding52.datelt4 : null;
            if (linearLayout20 != null) {
                linearLayout20.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding53 = get_binding();
            LinearLayout linearLayout21 = dialogDutyLeaveBinding53 != null ? dialogDutyLeaveBinding53.datelt5 : null;
            if (linearLayout21 != null) {
                linearLayout21.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding54 = get_binding();
            LinearLayout linearLayout22 = dialogDutyLeaveBinding54 != null ? dialogDutyLeaveBinding54.datelt6 : null;
            if (linearLayout22 != null) {
                linearLayout22.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding55 = get_binding();
            linearLayout = dialogDutyLeaveBinding55 != null ? dialogDutyLeaveBinding55.datelt7 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 8) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding56 = get_binding();
            LinearLayout linearLayout23 = dialogDutyLeaveBinding56 != null ? dialogDutyLeaveBinding56.datelt1 : null;
            if (linearLayout23 != null) {
                linearLayout23.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding57 = get_binding();
            LinearLayout linearLayout24 = dialogDutyLeaveBinding57 != null ? dialogDutyLeaveBinding57.datelt2 : null;
            if (linearLayout24 != null) {
                linearLayout24.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding58 = get_binding();
            LinearLayout linearLayout25 = dialogDutyLeaveBinding58 != null ? dialogDutyLeaveBinding58.datelt3 : null;
            if (linearLayout25 != null) {
                linearLayout25.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding59 = get_binding();
            LinearLayout linearLayout26 = dialogDutyLeaveBinding59 != null ? dialogDutyLeaveBinding59.datelt4 : null;
            if (linearLayout26 != null) {
                linearLayout26.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding60 = get_binding();
            LinearLayout linearLayout27 = dialogDutyLeaveBinding60 != null ? dialogDutyLeaveBinding60.datelt5 : null;
            if (linearLayout27 != null) {
                linearLayout27.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding61 = get_binding();
            LinearLayout linearLayout28 = dialogDutyLeaveBinding61 != null ? dialogDutyLeaveBinding61.datelt6 : null;
            if (linearLayout28 != null) {
                linearLayout28.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding62 = get_binding();
            LinearLayout linearLayout29 = dialogDutyLeaveBinding62 != null ? dialogDutyLeaveBinding62.datelt7 : null;
            if (linearLayout29 != null) {
                linearLayout29.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding63 = get_binding();
            linearLayout = dialogDutyLeaveBinding63 != null ? dialogDutyLeaveBinding63.datelt8 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 9) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding64 = get_binding();
            LinearLayout linearLayout30 = dialogDutyLeaveBinding64 != null ? dialogDutyLeaveBinding64.datelt1 : null;
            if (linearLayout30 != null) {
                linearLayout30.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding65 = get_binding();
            LinearLayout linearLayout31 = dialogDutyLeaveBinding65 != null ? dialogDutyLeaveBinding65.datelt2 : null;
            if (linearLayout31 != null) {
                linearLayout31.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding66 = get_binding();
            LinearLayout linearLayout32 = dialogDutyLeaveBinding66 != null ? dialogDutyLeaveBinding66.datelt3 : null;
            if (linearLayout32 != null) {
                linearLayout32.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding67 = get_binding();
            LinearLayout linearLayout33 = dialogDutyLeaveBinding67 != null ? dialogDutyLeaveBinding67.datelt4 : null;
            if (linearLayout33 != null) {
                linearLayout33.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding68 = get_binding();
            LinearLayout linearLayout34 = dialogDutyLeaveBinding68 != null ? dialogDutyLeaveBinding68.datelt6 : null;
            if (linearLayout34 != null) {
                linearLayout34.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding69 = get_binding();
            LinearLayout linearLayout35 = dialogDutyLeaveBinding69 != null ? dialogDutyLeaveBinding69.datelt7 : null;
            if (linearLayout35 != null) {
                linearLayout35.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding70 = get_binding();
            LinearLayout linearLayout36 = dialogDutyLeaveBinding70 != null ? dialogDutyLeaveBinding70.datelt8 : null;
            if (linearLayout36 != null) {
                linearLayout36.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding71 = get_binding();
            LinearLayout linearLayout37 = dialogDutyLeaveBinding71 != null ? dialogDutyLeaveBinding71.datelt9 : null;
            if (linearLayout37 != null) {
                linearLayout37.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding72 = get_binding();
            linearLayout = dialogDutyLeaveBinding72 != null ? dialogDutyLeaveBinding72.datelt5 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        } else if (valueOf != null && valueOf.intValue() == 10) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding73 = get_binding();
            LinearLayout linearLayout38 = dialogDutyLeaveBinding73 != null ? dialogDutyLeaveBinding73.datelt1 : null;
            if (linearLayout38 != null) {
                linearLayout38.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding74 = get_binding();
            LinearLayout linearLayout39 = dialogDutyLeaveBinding74 != null ? dialogDutyLeaveBinding74.datelt2 : null;
            if (linearLayout39 != null) {
                linearLayout39.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding75 = get_binding();
            LinearLayout linearLayout40 = dialogDutyLeaveBinding75 != null ? dialogDutyLeaveBinding75.datelt3 : null;
            if (linearLayout40 != null) {
                linearLayout40.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding76 = get_binding();
            LinearLayout linearLayout41 = dialogDutyLeaveBinding76 != null ? dialogDutyLeaveBinding76.datelt4 : null;
            if (linearLayout41 != null) {
                linearLayout41.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding77 = get_binding();
            LinearLayout linearLayout42 = dialogDutyLeaveBinding77 != null ? dialogDutyLeaveBinding77.datelt5 : null;
            if (linearLayout42 != null) {
                linearLayout42.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding78 = get_binding();
            LinearLayout linearLayout43 = dialogDutyLeaveBinding78 != null ? dialogDutyLeaveBinding78.datelt6 : null;
            if (linearLayout43 != null) {
                linearLayout43.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding79 = get_binding();
            LinearLayout linearLayout44 = dialogDutyLeaveBinding79 != null ? dialogDutyLeaveBinding79.datelt7 : null;
            if (linearLayout44 != null) {
                linearLayout44.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding80 = get_binding();
            LinearLayout linearLayout45 = dialogDutyLeaveBinding80 != null ? dialogDutyLeaveBinding80.datelt8 : null;
            if (linearLayout45 != null) {
                linearLayout45.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding81 = get_binding();
            LinearLayout linearLayout46 = dialogDutyLeaveBinding81 != null ? dialogDutyLeaveBinding81.datelt9 : null;
            if (linearLayout46 != null) {
                linearLayout46.setVisibility(0);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding82 = get_binding();
            linearLayout = dialogDutyLeaveBinding82 != null ? dialogDutyLeaveBinding82.datelt10 : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding83 = get_binding();
        if (dialogDutyLeaveBinding83 == null || (textView = dialogDutyLeaveBinding83.dutyUpload) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProofDutyLeave.setUp$lambda$14(ProofDutyLeave.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ProofDutyLeave this$0, View view) {
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxOne) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            TextView textView = dialogDutyLeaveBinding2 != null ? dialogDutyLeaveBinding2.date1 : null;
            if (textView == null) {
                return;
            }
            ArrayList<String> arrayList = this$0.appDates;
            textView.setText(arrayList != null ? arrayList.get(1) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxTwo) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date2) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxThree) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date3) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxFour) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date4) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxFive) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date5) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxSix) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date6) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxSeven) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date7) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxEight) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date8) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxNine) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date9) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(ProofDutyLeave this$0, View view) {
        TextView textView;
        CheckBox checkBox;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
        boolean z = false;
        if (dialogDutyLeaveBinding != null && (checkBox = dialogDutyLeaveBinding.checkBoxTen) != null && checkBox.isChecked()) {
            z = true;
        }
        if (z) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            System.out.println((dialogDutyLeaveBinding2 == null || (textView = dialogDutyLeaveBinding2.date10) == null) ? null : textView.getText());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$12(ProofDutyLeave this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$14(ProofDutyLeave this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            File file = this$0.pickFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            }
            if (file.exists()) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    String str = this$0.id;
                    if (str != null) {
                        ProofDutyLeaveViewModel proofDutyLeaveViewModel = this$0.getProofDutyLeaveViewModel();
                        File file3 = this$0.pickFile;
                        if (file3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                            file3 = null;
                        }
                        proofDutyLeaveViewModel.applyDutyLeave(str, file3);
                    }
                    DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
                    LinearLayout linearLayout = dialogDutyLeaveBinding != null ? dialogDutyLeaveBinding.dutyCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
                    LinearLayout linearLayout2 = dialogDutyLeaveBinding2 != null ? dialogDutyLeaveBinding2.progressView : null;
                    if (linearLayout2 == null) {
                        return;
                    }
                    linearLayout2.setVisibility(0);
                    return;
                }
                DialogDutyLeaveBinding dialogDutyLeaveBinding3 = this$0.get_binding();
                if (dialogDutyLeaveBinding3 == null || (textView3 = dialogDutyLeaveBinding3.dutySelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 200KB");
                return;
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding4 = this$0.get_binding();
            if (dialogDutyLeaveBinding4 == null || (textView2 = dialogDutyLeaveBinding4.dutySelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            DialogDutyLeaveBinding dialogDutyLeaveBinding5 = this$0.get_binding();
            if (dialogDutyLeaveBinding5 == null || (textView = dialogDutyLeaveBinding5.dutySelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Please Select A File");
        }
    }

    private final void listenResponse() {
        getProofDutyLeaveViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ProofDutyLeave.listenResponse$lambda$16(ProofDutyLeave.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$16(ProofDutyLeave this$0, Resource resource) {
        TextView fileName;
        TextView fileName2;
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
            DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
            if (dialogDutyLeaveBinding != null && (textView = dialogDutyLeaveBinding.fileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddLeaveCallBack addLeaveCallBack = this$0.listener;
            if (addLeaveCallBack != null) {
                addLeaveCallBack.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
                if (dialogDutyLeaveBinding2 != null && (fileName2 = dialogDutyLeaveBinding2.fileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(fileName2, "fileName");
                    ToastExtKt.showSuccessToast(fileName2, successResponse.getMessage());
                }
                AddLeaveCallBack addLeaveCallBack2 = this$0.listener;
                if (addLeaveCallBack2 != null) {
                    addLeaveCallBack2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding3 = this$0.get_binding();
            if (dialogDutyLeaveBinding3 != null && (fileName = dialogDutyLeaveBinding3.fileName) != null) {
                Intrinsics.checkNotNullExpressionValue(fileName, "fileName");
                ToastExtKt.showErrorToast(fileName, successResponse.getMessage());
            }
            AddLeaveCallBack addLeaveCallBack3 = this$0.listener;
            if (addLeaveCallBack3 != null) {
                addLeaveCallBack3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getProofDutyLeaveViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.duty.proof.ProofDutyLeave$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ProofDutyLeave.listenProgressResponse$lambda$18(ProofDutyLeave.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$18(ProofDutyLeave this$0, Resource resource) {
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
            DialogDutyLeaveBinding dialogDutyLeaveBinding = this$0.get_binding();
            if (dialogDutyLeaveBinding == null || (textView = dialogDutyLeaveBinding.fileName) == null) {
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
            DialogDutyLeaveBinding dialogDutyLeaveBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogDutyLeaveBinding2 != null ? dialogDutyLeaveBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogDutyLeaveBinding dialogDutyLeaveBinding3 = this$0.get_binding();
            TextView textView2 = dialogDutyLeaveBinding3 != null ? dialogDutyLeaveBinding3.progressText : null;
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
                DialogDutyLeaveBinding dialogDutyLeaveBinding = get_binding();
                TextView textView = dialogDutyLeaveBinding != null ? dialogDutyLeaveBinding.fileName : null;
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

    public final void checkbox() {
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        DialogDutyLeaveBinding dialogDutyLeaveBinding = get_binding();
        if ((dialogDutyLeaveBinding == null || (checkBox3 = dialogDutyLeaveBinding.checkBoxOne) == null || !checkBox3.isChecked()) ? false : true) {
            System.out.println((Object) "binding?.date1?.text");
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding2 = get_binding();
        if ((dialogDutyLeaveBinding2 == null || (checkBox2 = dialogDutyLeaveBinding2.checkBoxTwo) == null || !checkBox2.isChecked()) ? false : true) {
            System.out.println((Object) "binding?.date2?.text");
        }
        DialogDutyLeaveBinding dialogDutyLeaveBinding3 = get_binding();
        if ((dialogDutyLeaveBinding3 == null || (checkBox = dialogDutyLeaveBinding3.checkBoxThree) == null || !checkBox.isChecked()) ? false : true) {
            System.out.println((Object) "binding?.date3?.text");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof AddLeaveCallBack) {
            this.listener = (AddLeaveCallBack) context;
        } else {
            super.onAttach(context);
        }
    }

    public final void setAddLeaveCallBack(DutyLeaveFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddLeaveCallBack addLeaveCallBack = this.listener;
        if (addLeaveCallBack != null) {
            addLeaveCallBack.onDismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}