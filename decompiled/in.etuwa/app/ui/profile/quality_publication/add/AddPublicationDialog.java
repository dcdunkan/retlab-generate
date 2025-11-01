package in.etuwa.app.ui.profile.quality_publication.add;

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
import com.google.firebase.messaging.Constants;
import com.itextpdf.forms.xfdf.XfdfConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddUpdatePublicationBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.quality_publication.PublicationFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddPublicationDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\"\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0012\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u00020\"H\u0016J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u00020\"H\u0015J\b\u0010?\u001a\u00020\"H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddUpdatePublicationBinding;", "addPublicationViewModel", "Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationViewModel;", "getAddPublicationViewModel", "()Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationViewModel;", "addPublicationViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddUpdatePublicationBinding;", "fromDate", "", "id", "indexId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationDialog$AddPublicationListener;", "pickFile", "Ljava/io/File;", "reason", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "getSpinnerAdapter2", "spinnerAdapter2$delegate", "toDate", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/quality_publication/PublicationFragment;", "setUp", "showProgress", "AddPublicationListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddPublicationDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddUpdatePublicationBinding _binding;

    /* renamed from: addPublicationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addPublicationViewModel;
    private String fromDate;
    private String id;
    private String indexId;
    private AddPublicationListener listener;
    private File pickFile;
    private String reason;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String toDate;
    private String yearId;

    /* compiled from: AddPublicationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationDialog$AddPublicationListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddPublicationListener {
        void onDismiss();
    }

    /* compiled from: AddPublicationDialog.kt */
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
    public static final AddPublicationDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddPublicationDialog() {
        final AddPublicationDialog addPublicationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addPublicationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addPublicationViewModel = FragmentViewModelLazyKt.createViewModelLazy(addPublicationDialog, Reflection.getOrCreateKotlinClass(AddPublicationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddPublicationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddPublicationDialog addPublicationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddPublicationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addPublicationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddPublicationDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addPublicationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b3, function03);
            }
        });
    }

    private final AddPublicationViewModel getAddPublicationViewModel() {
        return (AddPublicationViewModel) this.addPublicationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddUpdatePublicationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter() {
        return (IndexSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter2() {
        return (IndexSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* compiled from: AddPublicationDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/quality_publication/add/AddPublicationDialog;", "id", "", "reason", "fromDate", "toDate", XfdfConstants.HEAD, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddPublicationDialog newInstance(String id, String reason, String fromDate, String toDate, String head) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(fromDate, "fromDate");
            Intrinsics.checkNotNullParameter(toDate, "toDate");
            Intrinsics.checkNotNullParameter(head, "head");
            AddPublicationDialog addPublicationDialog = new AddPublicationDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, reason);
            bundle.putString("url", fromDate);
            bundle.putString("fine", toDate);
            bundle.putString("fixed", head);
            addPublicationDialog.setArguments(bundle);
            return addPublicationDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.reason = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.fromDate = arguments.getString("url");
            this.toDate = arguments.getString("fine");
            this.yearId = arguments.getString("fixed");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddUpdatePublicationBinding.inflate(inflater, container, false);
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = get_binding();
        if (dialogAddUpdatePublicationBinding != null) {
            dialogAddUpdatePublicationBinding.setAddPublicationViewModel(getAddPublicationViewModel());
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = get_binding();
        if (dialogAddUpdatePublicationBinding2 != null) {
            dialogAddUpdatePublicationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = get_binding();
        if (dialogAddUpdatePublicationBinding3 != null) {
            return dialogAddUpdatePublicationBinding3.getRoot();
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
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = get_binding();
        Spinner spinner = dialogAddUpdatePublicationBinding != null ? dialogAddUpdatePublicationBinding.spinnerIndex : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = get_binding();
        Spinner spinner2 = dialogAddUpdatePublicationBinding2 != null ? dialogAddUpdatePublicationBinding2.spinnerYear : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddPublicationViewModel().getPublicationData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = get_binding();
            TextView textView4 = dialogAddUpdatePublicationBinding3 != null ? dialogAddUpdatePublicationBinding3.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding4 = get_binding();
            TextView textView5 = dialogAddUpdatePublicationBinding4 != null ? dialogAddUpdatePublicationBinding4.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding5 = get_binding();
            TextView textView6 = dialogAddUpdatePublicationBinding5 != null ? dialogAddUpdatePublicationBinding5.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding6 = get_binding();
            TextView textView7 = dialogAddUpdatePublicationBinding6 != null ? dialogAddUpdatePublicationBinding6.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding7 = get_binding();
        if (dialogAddUpdatePublicationBinding7 != null && (textInputEditText3 = dialogAddUpdatePublicationBinding7.etTitle) != null) {
            textInputEditText3.setText(this.reason);
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding8 = get_binding();
        if (dialogAddUpdatePublicationBinding8 != null && (textInputEditText2 = dialogAddUpdatePublicationBinding8.etJournel) != null) {
            textInputEditText2.setText(this.fromDate);
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding9 = get_binding();
        if (dialogAddUpdatePublicationBinding9 != null && (textInputEditText = dialogAddUpdatePublicationBinding9.etConference) != null) {
            textInputEditText.setText(this.toDate);
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding10 = get_binding();
        Spinner spinner3 = dialogAddUpdatePublicationBinding10 != null ? dialogAddUpdatePublicationBinding10.spinnerYear : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter2;
                    AddPublicationDialog addPublicationDialog = AddPublicationDialog.this;
                    spinnerAdapter2 = addPublicationDialog.getSpinnerAdapter2();
                    addPublicationDialog.yearId = String.valueOf(spinnerAdapter2.getSemester(position).getId());
                }
            });
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding11 = get_binding();
        Spinner spinner4 = dialogAddUpdatePublicationBinding11 != null ? dialogAddUpdatePublicationBinding11.spinnerIndex : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddPublicationDialog addPublicationDialog = AddPublicationDialog.this;
                    spinnerAdapter = addPublicationDialog.getSpinnerAdapter();
                    addPublicationDialog.indexId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding12 = get_binding();
        if (dialogAddUpdatePublicationBinding12 != null && (textView3 = dialogAddUpdatePublicationBinding12.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPublicationDialog.setUp$lambda$2(AddPublicationDialog.this, view);
                }
            });
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding13 = get_binding();
        if (dialogAddUpdatePublicationBinding13 != null && (textView2 = dialogAddUpdatePublicationBinding13.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddPublicationDialog.setUp$lambda$3(AddPublicationDialog.this, view);
                }
            });
        }
        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding14 = get_binding();
        if (dialogAddUpdatePublicationBinding14 == null || (textView = dialogAddUpdatePublicationBinding14.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddPublicationDialog.setUp$lambda$4(AddPublicationDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddPublicationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddPublicationDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextView textView;
        TextInputEditText textInputEditText4;
        TextView textView2;
        File file;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView3;
        TextInputEditText textInputEditText8;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            if (String.valueOf((dialogAddUpdatePublicationBinding == null || (textView4 = dialogAddUpdatePublicationBinding.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddUpdatePublicationBinding2 == null || (textInputEditText8 = dialogAddUpdatePublicationBinding2.etTitle) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
                        if (dialogAddUpdatePublicationBinding3 == null || (textView3 = dialogAddUpdatePublicationBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Publication Title Cannot be empty");
                        return;
                    }
                    AddPublicationViewModel addPublicationViewModel = this$0.getAddPublicationViewModel();
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddUpdatePublicationBinding4 == null || (textInputEditText7 = dialogAddUpdatePublicationBinding4.etTitle) == null) ? null : textInputEditText7.getText());
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding5 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddUpdatePublicationBinding5 == null || (textInputEditText6 = dialogAddUpdatePublicationBinding5.etJournel) == null) ? null : textInputEditText6.getText());
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding6 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddUpdatePublicationBinding6 == null || (textInputEditText5 = dialogAddUpdatePublicationBinding6.etConference) == null) ? null : textInputEditText5.getText());
                    String str = this$0.indexId;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addPublicationViewModel.addPublicationData(valueOf, valueOf2, valueOf3, str, str2, file);
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding7 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddUpdatePublicationBinding7 != null ? dialogAddUpdatePublicationBinding7.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding8 = this$0.get_binding();
                    CardView cardView = dialogAddUpdatePublicationBinding8 != null ? dialogAddUpdatePublicationBinding8.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding9 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding9 == null || (textView2 = dialogAddUpdatePublicationBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 100KB");
                return;
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding10 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddUpdatePublicationBinding10 == null || (textInputEditText4 = dialogAddUpdatePublicationBinding10.etTitle) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding11 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding11 == null || (textView = dialogAddUpdatePublicationBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Publication Title Cannot be empty");
                return;
            }
            AddPublicationViewModel addPublicationViewModel2 = this$0.getAddPublicationViewModel();
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding12 = this$0.get_binding();
            String valueOf4 = String.valueOf((dialogAddUpdatePublicationBinding12 == null || (textInputEditText3 = dialogAddUpdatePublicationBinding12.etTitle) == null) ? null : textInputEditText3.getText());
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding13 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddUpdatePublicationBinding13 == null || (textInputEditText2 = dialogAddUpdatePublicationBinding13.etJournel) == null) ? null : textInputEditText2.getText());
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding14 = this$0.get_binding();
            String valueOf6 = String.valueOf((dialogAddUpdatePublicationBinding14 == null || (textInputEditText = dialogAddUpdatePublicationBinding14.etConference) == null) ? null : textInputEditText.getText());
            String str3 = this$0.indexId;
            Intrinsics.checkNotNull(str3);
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            addPublicationViewModel2.addPublicationData(valueOf4, valueOf5, valueOf6, str3, str4);
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding15 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddUpdatePublicationBinding15 != null ? dialogAddUpdatePublicationBinding15.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddPublicationDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextView textView;
        TextInputEditText textInputEditText4;
        TextView textView2;
        File file;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView3;
        TextInputEditText textInputEditText8;
        TextView textView4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddUpdatePublicationBinding == null || (textView4 = dialogAddUpdatePublicationBinding.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddUpdatePublicationBinding2 == null || (textInputEditText8 = dialogAddUpdatePublicationBinding2.etTitle) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
                        if (dialogAddUpdatePublicationBinding3 == null || (textView3 = dialogAddUpdatePublicationBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Publication Title Cannot be empty");
                        return;
                    }
                    AddPublicationViewModel addPublicationViewModel = this$0.getAddPublicationViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddUpdatePublicationBinding4 == null || (textInputEditText7 = dialogAddUpdatePublicationBinding4.etTitle) == null) ? null : textInputEditText7.getText());
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding5 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddUpdatePublicationBinding5 == null || (textInputEditText6 = dialogAddUpdatePublicationBinding5.etJournel) == null) ? null : textInputEditText6.getText());
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding6 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddUpdatePublicationBinding6 == null || (textInputEditText5 = dialogAddUpdatePublicationBinding6.etConference) == null) ? null : textInputEditText5.getText());
                    String str2 = this$0.indexId;
                    Intrinsics.checkNotNull(str2);
                    String str3 = this$0.yearId;
                    Intrinsics.checkNotNull(str3);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addPublicationViewModel.addPublicationData(str, valueOf, valueOf2, valueOf3, str2, str3, file);
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding7 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddUpdatePublicationBinding7 != null ? dialogAddUpdatePublicationBinding7.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding8 = this$0.get_binding();
                    CardView cardView = dialogAddUpdatePublicationBinding8 != null ? dialogAddUpdatePublicationBinding8.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding9 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding9 == null || (textView2 = dialogAddUpdatePublicationBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 100KB");
                return;
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding10 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddUpdatePublicationBinding10 == null || (textInputEditText4 = dialogAddUpdatePublicationBinding10.etTitle) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding11 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding11 == null || (textView = dialogAddUpdatePublicationBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Publication Title Cannot be empty");
                return;
            }
            AddPublicationViewModel addPublicationViewModel2 = this$0.getAddPublicationViewModel();
            String str4 = this$0.id;
            Intrinsics.checkNotNull(str4);
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding12 = this$0.get_binding();
            String valueOf4 = String.valueOf((dialogAddUpdatePublicationBinding12 == null || (textInputEditText3 = dialogAddUpdatePublicationBinding12.etTitle) == null) ? null : textInputEditText3.getText());
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding13 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddUpdatePublicationBinding13 == null || (textInputEditText2 = dialogAddUpdatePublicationBinding13.etJournel) == null) ? null : textInputEditText2.getText());
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding14 = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding14 != null && (textInputEditText = dialogAddUpdatePublicationBinding14.etConference) != null) {
                editable = textInputEditText.getText();
            }
            String valueOf6 = String.valueOf(editable);
            String str5 = this$0.indexId;
            Intrinsics.checkNotNull(str5);
            String str6 = this$0.yearId;
            Intrinsics.checkNotNull(str6);
            addPublicationViewModel2.updatePublicationData(str4, valueOf4, valueOf5, valueOf6, str5, str6);
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddPublicationViewModel().getResponse().observe(getViewLifecycleOwner(), new AddPublicationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$listenSpinnerResponse$1

            /* compiled from: AddPublicationDialog.kt */
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
                IndexSpinnerAdapter spinnerAdapter2;
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddPublicationDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        AddPublicationDialog addPublicationDialog = AddPublicationDialog.this;
                        try {
                            spinnerAdapter = addPublicationDialog.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getIndex());
                            spinnerAdapter2 = addPublicationDialog.getSpinnerAdapter2();
                            spinnerAdapter2.addItems(data.getYears());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddPublicationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddPublicationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddPublicationDialog.this.hideProgress();
                dialogAddUpdatePublicationBinding = AddPublicationDialog.this.get_binding();
                if (dialogAddUpdatePublicationBinding == null || (spinner = dialogAddUpdatePublicationBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddPublicationViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPublicationDialog.listenAddResponse$lambda$6(AddPublicationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddPublicationDialog this$0, Resource resource) {
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
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding != null && (textView = dialogAddUpdatePublicationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPublicationListener addPublicationListener = this$0.listener;
            if (addPublicationListener != null) {
                addPublicationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding2 != null && (addBtn2 = dialogAddUpdatePublicationBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddPublicationListener addPublicationListener2 = this$0.listener;
                if (addPublicationListener2 != null) {
                    addPublicationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding3 != null && (addBtn = dialogAddUpdatePublicationBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddPublicationListener addPublicationListener3 = this$0.listener;
            if (addPublicationListener3 != null) {
                addPublicationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddPublicationViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPublicationDialog.listenAddResponse2$lambda$8(AddPublicationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddPublicationDialog this$0, Resource resource) {
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
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding != null && (textView = dialogAddUpdatePublicationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPublicationListener addPublicationListener = this$0.listener;
            if (addPublicationListener != null) {
                addPublicationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding2 != null && (addBtn2 = dialogAddUpdatePublicationBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddPublicationListener addPublicationListener2 = this$0.listener;
                if (addPublicationListener2 != null) {
                    addPublicationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding3 != null && (addBtn = dialogAddUpdatePublicationBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddPublicationListener addPublicationListener3 = this$0.listener;
            if (addPublicationListener3 != null) {
                addPublicationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddPublicationViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPublicationDialog.listenUpdateResponse$lambda$10(AddPublicationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddPublicationDialog this$0, Resource resource) {
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
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding != null && (textView = dialogAddUpdatePublicationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddPublicationListener addPublicationListener = this$0.listener;
            if (addPublicationListener != null) {
                addPublicationListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
                if (dialogAddUpdatePublicationBinding2 != null && (completionFileName2 = dialogAddUpdatePublicationBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddPublicationListener addPublicationListener2 = this$0.listener;
                if (addPublicationListener2 != null) {
                    addPublicationListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding3 != null && (completionFileName = dialogAddUpdatePublicationBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddPublicationListener addPublicationListener3 = this$0.listener;
            if (addPublicationListener3 != null) {
                addPublicationListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddPublicationViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.quality_publication.add.AddPublicationDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddPublicationDialog.listenProgressResponse$lambda$12(AddPublicationDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddPublicationDialog this$0, Resource resource) {
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
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = this$0.get_binding();
            if (dialogAddUpdatePublicationBinding == null || (textView = dialogAddUpdatePublicationBinding.completionFileName) == null) {
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
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddUpdatePublicationBinding2 != null ? dialogAddUpdatePublicationBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddUpdatePublicationBinding3 != null ? dialogAddUpdatePublicationBinding3.progressText : null;
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
                    DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding = get_binding();
                    if (dialogAddUpdatePublicationBinding == null || (completionFileName = dialogAddUpdatePublicationBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddUpdatePublicationBinding dialogAddUpdatePublicationBinding2 = get_binding();
                TextView textView = dialogAddUpdatePublicationBinding2 != null ? dialogAddUpdatePublicationBinding2.completionFileName : null;
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

    public final void setCallBack(PublicationFragment context) {
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