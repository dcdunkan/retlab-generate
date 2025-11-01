package in.etuwa.app.ui.profile.membership.add;

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
import com.itextpdf.kernel.xmp.PdfConst;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddMembershipBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.leave.duty.fullday.FullDayDialogKt;
import in.etuwa.app.ui.profile.membership.MembershipFragment;
import in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter;
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

/* compiled from: AddMembershipDialog.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 A2\u00020\u0001:\u0002@AB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\"H\u0002J\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0002J\"\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010,\u001a\u0004\u0018\u00010-H\u0017J\u0012\u0010.\u001a\u00020\"2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00107\u001a\u00020\"H\u0016J\b\u00108\u001a\u00020\"H\u0016J\u001a\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u0002022\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020=J\b\u0010>\u001a\u00020\"H\u0015J\b\u0010?\u001a\u00020\"H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001d\u0010\u001aR\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/profile/membership/add/AddMembershipDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddMembershipBinding;", "addMembershipViewModel", "Lin/etuwa/app/ui/profile/membership/add/AddMembershipViewModel;", "getAddMembershipViewModel", "()Lin/etuwa/app/ui/profile/membership/add/AddMembershipViewModel;", "addMembershipViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddMembershipBinding;", PdfConst.Description, "", "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/membership/add/AddMembershipDialog$AddMembershipListener;", "membershipId", "name", "pickFile", "Ljava/io/File;", "spinnerAdapter", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter$delegate", "spinnerAdapter2", "getSpinnerAdapter2", "spinnerAdapter2$delegate", "type", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/membership/MembershipFragment;", "setUp", "showProgress", "AddMembershipListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddMembershipDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddMembershipBinding _binding;

    /* renamed from: addMembershipViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addMembershipViewModel;
    private String description;
    private String id;
    private AddMembershipListener listener;
    private String membershipId;
    private String name;
    private File pickFile;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String type;
    private String yearId;

    /* compiled from: AddMembershipDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/membership/add/AddMembershipDialog$AddMembershipListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddMembershipListener {
        void onDismiss();
    }

    /* compiled from: AddMembershipDialog.kt */
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
    public static final AddMembershipDialog newInstance(String str, String str2, String str3, String str4) {
        return INSTANCE.newInstance(str, str2, str3, str4);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddMembershipDialog() {
        final AddMembershipDialog addMembershipDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addMembershipDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addMembershipViewModel = FragmentViewModelLazyKt.createViewModelLazy(addMembershipDialog, Reflection.getOrCreateKotlinClass(AddMembershipViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddMembershipViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddMembershipDialog addMembershipDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddMembershipDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addMembershipDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddMembershipDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addMembershipDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b3, function03);
            }
        });
    }

    private final AddMembershipViewModel getAddMembershipViewModel() {
        return (AddMembershipViewModel) this.addMembershipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddMembershipBinding get_binding() {
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

    /* compiled from: AddMembershipDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/profile/membership/add/AddMembershipDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/membership/add/AddMembershipDialog;", "id", "", "name", "membershipId", PdfConst.Description, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddMembershipDialog newInstance(String id, String name, String membershipId, String description) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(membershipId, "membershipId");
            Intrinsics.checkNotNullParameter(description, "description");
            AddMembershipDialog addMembershipDialog = new AddMembershipDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, name);
            bundle.putString("fine", membershipId);
            bundle.putString(FullDayDialogKt.ARG_BTN, description);
            addMembershipDialog.setArguments(bundle);
            return addMembershipDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.name = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.membershipId = arguments.getString("fine");
            this.description = arguments.getString(FullDayDialogKt.ARG_BTN);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddMembershipBinding.inflate(inflater, container, false);
        DialogAddMembershipBinding dialogAddMembershipBinding = get_binding();
        if (dialogAddMembershipBinding != null) {
            dialogAddMembershipBinding.setAddMembershipViewModel(getAddMembershipViewModel());
        }
        DialogAddMembershipBinding dialogAddMembershipBinding2 = get_binding();
        if (dialogAddMembershipBinding2 != null) {
            dialogAddMembershipBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddMembershipBinding dialogAddMembershipBinding3 = get_binding();
        if (dialogAddMembershipBinding3 != null) {
            return dialogAddMembershipBinding3.getRoot();
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
        DialogAddMembershipBinding dialogAddMembershipBinding = get_binding();
        Spinner spinner = dialogAddMembershipBinding != null ? dialogAddMembershipBinding.spinnerSince : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogAddMembershipBinding dialogAddMembershipBinding2 = get_binding();
        Spinner spinner2 = dialogAddMembershipBinding2 != null ? dialogAddMembershipBinding2.spinnerType : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddMembershipViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddMembershipBinding dialogAddMembershipBinding3 = get_binding();
            TextView textView4 = dialogAddMembershipBinding3 != null ? dialogAddMembershipBinding3.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddMembershipBinding dialogAddMembershipBinding4 = get_binding();
            TextView textView5 = dialogAddMembershipBinding4 != null ? dialogAddMembershipBinding4.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddMembershipBinding dialogAddMembershipBinding5 = get_binding();
            TextView textView6 = dialogAddMembershipBinding5 != null ? dialogAddMembershipBinding5.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddMembershipBinding dialogAddMembershipBinding6 = get_binding();
            TextView textView7 = dialogAddMembershipBinding6 != null ? dialogAddMembershipBinding6.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddMembershipBinding dialogAddMembershipBinding7 = get_binding();
        if (dialogAddMembershipBinding7 != null && (textInputEditText3 = dialogAddMembershipBinding7.etName) != null) {
            textInputEditText3.setText(this.name);
        }
        DialogAddMembershipBinding dialogAddMembershipBinding8 = get_binding();
        if (dialogAddMembershipBinding8 != null && (textInputEditText2 = dialogAddMembershipBinding8.etMembershipId) != null) {
            textInputEditText2.setText(this.membershipId);
        }
        DialogAddMembershipBinding dialogAddMembershipBinding9 = get_binding();
        if (dialogAddMembershipBinding9 != null && (textInputEditText = dialogAddMembershipBinding9.etDescription) != null) {
            textInputEditText.setText(this.description);
        }
        DialogAddMembershipBinding dialogAddMembershipBinding10 = get_binding();
        Spinner spinner3 = dialogAddMembershipBinding10 != null ? dialogAddMembershipBinding10.spinnerSince : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter;
                    AddMembershipDialog addMembershipDialog = AddMembershipDialog.this;
                    spinnerAdapter = addMembershipDialog.getSpinnerAdapter();
                    addMembershipDialog.yearId = String.valueOf(spinnerAdapter.getSemester(position).getId());
                }
            });
        }
        DialogAddMembershipBinding dialogAddMembershipBinding11 = get_binding();
        Spinner spinner4 = dialogAddMembershipBinding11 != null ? dialogAddMembershipBinding11.spinnerType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$setUp$2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter2;
                    AddMembershipDialog addMembershipDialog = AddMembershipDialog.this;
                    spinnerAdapter2 = addMembershipDialog.getSpinnerAdapter2();
                    addMembershipDialog.type = String.valueOf(spinnerAdapter2.getSemester(position).getId());
                }
            });
        }
        DialogAddMembershipBinding dialogAddMembershipBinding12 = get_binding();
        if (dialogAddMembershipBinding12 != null && (textView3 = dialogAddMembershipBinding12.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMembershipDialog.setUp$lambda$2(AddMembershipDialog.this, view);
                }
            });
        }
        DialogAddMembershipBinding dialogAddMembershipBinding13 = get_binding();
        if (dialogAddMembershipBinding13 != null && (textView2 = dialogAddMembershipBinding13.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMembershipDialog.setUp$lambda$3(AddMembershipDialog.this, view);
                }
            });
        }
        DialogAddMembershipBinding dialogAddMembershipBinding14 = get_binding();
        if (dialogAddMembershipBinding14 == null || (textView = dialogAddMembershipBinding14.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddMembershipDialog.setUp$lambda$4(AddMembershipDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddMembershipDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddMembershipDialog this$0, View view) {
        TextView textView;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextView textView2;
        TextInputEditText textInputEditText4;
        TextView textView3;
        File file;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView4;
        TextInputEditText textInputEditText8;
        TextView textView5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            if (String.valueOf((dialogAddMembershipBinding == null || (textView5 = dialogAddMembershipBinding.completionFileName) == null) ? null : textView5.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddMembershipBinding2 == null || (textInputEditText8 = dialogAddMembershipBinding2.etName) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
                        if (dialogAddMembershipBinding3 == null || (textView4 = dialogAddMembershipBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Name of the professional society Cannot be empty");
                        return;
                    }
                    AddMembershipViewModel addMembershipViewModel = this$0.getAddMembershipViewModel();
                    DialogAddMembershipBinding dialogAddMembershipBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddMembershipBinding4 == null || (textInputEditText7 = dialogAddMembershipBinding4.etName) == null) ? null : textInputEditText7.getText());
                    String str = this$0.type;
                    Intrinsics.checkNotNull(str);
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    DialogAddMembershipBinding dialogAddMembershipBinding5 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddMembershipBinding5 == null || (textInputEditText6 = dialogAddMembershipBinding5.etMembershipId) == null) ? null : textInputEditText6.getText());
                    DialogAddMembershipBinding dialogAddMembershipBinding6 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddMembershipBinding6 == null || (textInputEditText5 = dialogAddMembershipBinding6.etDescription) == null) ? null : textInputEditText5.getText());
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addMembershipViewModel.addMembershipData(valueOf, str, str2, valueOf2, valueOf3, file);
                    DialogAddMembershipBinding dialogAddMembershipBinding7 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddMembershipBinding7 != null ? dialogAddMembershipBinding7.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddMembershipBinding dialogAddMembershipBinding8 = this$0.get_binding();
                    CardView cardView = dialogAddMembershipBinding8 != null ? dialogAddMembershipBinding8.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddMembershipBinding dialogAddMembershipBinding9 = this$0.get_binding();
                if (dialogAddMembershipBinding9 == null || (textView3 = dialogAddMembershipBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 200KB");
                return;
            }
            DialogAddMembershipBinding dialogAddMembershipBinding10 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddMembershipBinding10 == null || (textInputEditText4 = dialogAddMembershipBinding10.etName) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddMembershipBinding dialogAddMembershipBinding11 = this$0.get_binding();
                if (dialogAddMembershipBinding11 == null || (textView2 = dialogAddMembershipBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Name of the professional society Cannot be empty");
                return;
            }
            AddMembershipViewModel addMembershipViewModel2 = this$0.getAddMembershipViewModel();
            DialogAddMembershipBinding dialogAddMembershipBinding12 = this$0.get_binding();
            String valueOf4 = String.valueOf((dialogAddMembershipBinding12 == null || (textInputEditText3 = dialogAddMembershipBinding12.etName) == null) ? null : textInputEditText3.getText());
            String str3 = this$0.type;
            Intrinsics.checkNotNull(str3);
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            DialogAddMembershipBinding dialogAddMembershipBinding13 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddMembershipBinding13 == null || (textInputEditText2 = dialogAddMembershipBinding13.etMembershipId) == null) ? null : textInputEditText2.getText());
            DialogAddMembershipBinding dialogAddMembershipBinding14 = this$0.get_binding();
            addMembershipViewModel2.addMembershipData(valueOf4, str3, str4, valueOf5, String.valueOf((dialogAddMembershipBinding14 == null || (textInputEditText = dialogAddMembershipBinding14.etDescription) == null) ? null : textInputEditText.getText()));
            DialogAddMembershipBinding dialogAddMembershipBinding15 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddMembershipBinding15 != null ? dialogAddMembershipBinding15.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
            DialogAddMembershipBinding dialogAddMembershipBinding16 = this$0.get_binding();
            if (dialogAddMembershipBinding16 == null || (textView = dialogAddMembershipBinding16.addBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Something went wrong.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddMembershipDialog this$0, View view) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddMembershipBinding == null || (textView4 = dialogAddMembershipBinding.completionFileName) == null) ? null : textView4.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddMembershipBinding2 == null || (textInputEditText8 = dialogAddMembershipBinding2.etName) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
                        if (dialogAddMembershipBinding3 == null || (textView3 = dialogAddMembershipBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView3, "Name of the professional society Cannot be empty");
                        return;
                    }
                    AddMembershipViewModel addMembershipViewModel = this$0.getAddMembershipViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    DialogAddMembershipBinding dialogAddMembershipBinding4 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddMembershipBinding4 == null || (textInputEditText7 = dialogAddMembershipBinding4.etName) == null) ? null : textInputEditText7.getText());
                    String str2 = this$0.type;
                    Intrinsics.checkNotNull(str2);
                    String str3 = this$0.yearId;
                    Intrinsics.checkNotNull(str3);
                    DialogAddMembershipBinding dialogAddMembershipBinding5 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddMembershipBinding5 == null || (textInputEditText6 = dialogAddMembershipBinding5.etMembershipId) == null) ? null : textInputEditText6.getText());
                    DialogAddMembershipBinding dialogAddMembershipBinding6 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddMembershipBinding6 == null || (textInputEditText5 = dialogAddMembershipBinding6.etDescription) == null) ? null : textInputEditText5.getText());
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addMembershipViewModel.updateMembershipData(str, valueOf, str2, str3, valueOf2, valueOf3, file);
                    DialogAddMembershipBinding dialogAddMembershipBinding7 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddMembershipBinding7 != null ? dialogAddMembershipBinding7.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddMembershipBinding dialogAddMembershipBinding8 = this$0.get_binding();
                    CardView cardView = dialogAddMembershipBinding8 != null ? dialogAddMembershipBinding8.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddMembershipBinding dialogAddMembershipBinding9 = this$0.get_binding();
                if (dialogAddMembershipBinding9 == null || (textView2 = dialogAddMembershipBinding9.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "File Size Limit Is 100KB");
                return;
            }
            DialogAddMembershipBinding dialogAddMembershipBinding10 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddMembershipBinding10 == null || (textInputEditText4 = dialogAddMembershipBinding10.etName) == null) ? null : textInputEditText4.getText()), "")) {
                DialogAddMembershipBinding dialogAddMembershipBinding11 = this$0.get_binding();
                if (dialogAddMembershipBinding11 == null || (textView = dialogAddMembershipBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Name of the professional society Cannot be empty");
                return;
            }
            AddMembershipViewModel addMembershipViewModel2 = this$0.getAddMembershipViewModel();
            String str4 = this$0.id;
            Intrinsics.checkNotNull(str4);
            DialogAddMembershipBinding dialogAddMembershipBinding12 = this$0.get_binding();
            String valueOf4 = String.valueOf((dialogAddMembershipBinding12 == null || (textInputEditText3 = dialogAddMembershipBinding12.etName) == null) ? null : textInputEditText3.getText());
            String str5 = this$0.type;
            Intrinsics.checkNotNull(str5);
            String str6 = this$0.yearId;
            Intrinsics.checkNotNull(str6);
            DialogAddMembershipBinding dialogAddMembershipBinding13 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddMembershipBinding13 == null || (textInputEditText2 = dialogAddMembershipBinding13.etMembershipId) == null) ? null : textInputEditText2.getText());
            DialogAddMembershipBinding dialogAddMembershipBinding14 = this$0.get_binding();
            if (dialogAddMembershipBinding14 != null && (textInputEditText = dialogAddMembershipBinding14.etDescription) != null) {
                editable = textInputEditText.getText();
            }
            addMembershipViewModel2.updateMembershipData(str4, valueOf4, str5, str6, valueOf5, String.valueOf(editable));
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddMembershipViewModel().getResponse().observe(getViewLifecycleOwner(), new AddMembershipDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$listenSpinnerResponse$1

            /* compiled from: AddMembershipDialog.kt */
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
                DialogAddMembershipBinding dialogAddMembershipBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddMembershipDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        AddMembershipDialog addMembershipDialog = AddMembershipDialog.this;
                        try {
                            spinnerAdapter = addMembershipDialog.getSpinnerAdapter();
                            spinnerAdapter.addItems(data.getYears());
                            spinnerAdapter2 = addMembershipDialog.getSpinnerAdapter2();
                            spinnerAdapter2.addItems(data.getMembership());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddMembershipDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddMembershipDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddMembershipDialog.this.hideProgress();
                dialogAddMembershipBinding = AddMembershipDialog.this.get_binding();
                if (dialogAddMembershipBinding == null || (spinner = dialogAddMembershipBinding.spinnerType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddMembershipViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMembershipDialog.listenAddResponse$lambda$6(AddMembershipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddMembershipDialog this$0, Resource resource) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            if (dialogAddMembershipBinding != null && (textView = dialogAddMembershipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMembershipListener addMembershipListener = this$0.listener;
            if (addMembershipListener != null) {
                addMembershipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
                if (dialogAddMembershipBinding2 != null && (addBtn2 = dialogAddMembershipBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddMembershipListener addMembershipListener2 = this$0.listener;
                if (addMembershipListener2 != null) {
                    addMembershipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
            if (dialogAddMembershipBinding3 != null && (addBtn = dialogAddMembershipBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddMembershipListener addMembershipListener3 = this$0.listener;
            if (addMembershipListener3 != null) {
                addMembershipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddMembershipViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda5
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMembershipDialog.listenAddResponse2$lambda$8(AddMembershipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddMembershipDialog this$0, Resource resource) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            if (dialogAddMembershipBinding != null && (textView = dialogAddMembershipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMembershipListener addMembershipListener = this$0.listener;
            if (addMembershipListener != null) {
                addMembershipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
                if (dialogAddMembershipBinding2 != null && (addBtn2 = dialogAddMembershipBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddMembershipListener addMembershipListener2 = this$0.listener;
                if (addMembershipListener2 != null) {
                    addMembershipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
            if (dialogAddMembershipBinding3 != null && (addBtn = dialogAddMembershipBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddMembershipListener addMembershipListener3 = this$0.listener;
            if (addMembershipListener3 != null) {
                addMembershipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddMembershipViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMembershipDialog.listenUpdateResponse$lambda$10(AddMembershipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddMembershipDialog this$0, Resource resource) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            if (dialogAddMembershipBinding != null && (textView = dialogAddMembershipBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddMembershipListener addMembershipListener = this$0.listener;
            if (addMembershipListener != null) {
                addMembershipListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
                if (dialogAddMembershipBinding2 != null && (completionFileName2 = dialogAddMembershipBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddMembershipListener addMembershipListener2 = this$0.listener;
                if (addMembershipListener2 != null) {
                    addMembershipListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
            if (dialogAddMembershipBinding3 != null && (completionFileName = dialogAddMembershipBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddMembershipListener addMembershipListener3 = this$0.listener;
            if (addMembershipListener3 != null) {
                addMembershipListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddMembershipViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.membership.add.AddMembershipDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMembershipDialog.listenProgressResponse$lambda$12(AddMembershipDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddMembershipDialog this$0, Resource resource) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding = this$0.get_binding();
            if (dialogAddMembershipBinding == null || (textView = dialogAddMembershipBinding.completionFileName) == null) {
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
            DialogAddMembershipBinding dialogAddMembershipBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddMembershipBinding2 != null ? dialogAddMembershipBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddMembershipBinding dialogAddMembershipBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddMembershipBinding3 != null ? dialogAddMembershipBinding3.progressText : null;
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
                    DialogAddMembershipBinding dialogAddMembershipBinding = get_binding();
                    if (dialogAddMembershipBinding == null || (completionFileName = dialogAddMembershipBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddMembershipBinding dialogAddMembershipBinding2 = get_binding();
                TextView textView = dialogAddMembershipBinding2 != null ? dialogAddMembershipBinding2.completionFileName : null;
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

    public final void setCallBack(MembershipFragment context) {
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