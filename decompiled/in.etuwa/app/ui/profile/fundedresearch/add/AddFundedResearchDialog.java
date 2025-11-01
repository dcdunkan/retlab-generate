package in.etuwa.app.ui.profile.fundedresearch.add;

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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.profileasiet.publication.PublicationDropDownResponse;
import in.etuwa.app.databinding.DialogAddFundedResearchBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.detaildialog.ExamSubjectDetailDialogKt;
import in.etuwa.app.ui.profile.fundedresearch.FundedResearchFragment;
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

/* compiled from: AddFundedResearchDialog.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 >2\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002J\"\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*H\u0017J\u0012\u0010+\u001a\u00020\u001f2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\b\u00105\u001a\u00020\u001fH\u0016J\u001a\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020/2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020\u001fH\u0015J\b\u0010<\u001a\u00020\u001fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogAddFundedResearchBinding;", "addFundedResearchViewModel", "Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchViewModel;", "getAddFundedResearchViewModel", "()Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchViewModel;", "addFundedResearchViewModel$delegate", "Lkotlin/Lazy;", "agency", "", ExamSubjectDetailDialogKt.ARG_AMOUNT, "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogAddFundedResearchBinding;", TypedValues.TransitionType.S_DURATION, "id", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog$AddFundedResearchListener;", "pickFile", "Ljava/io/File;", "spinnerAdapter2", "Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "getSpinnerAdapter2", "()Lin/etuwa/app/ui/profile/quality_publication/add/IndexSpinnerAdapter;", "spinnerAdapter2$delegate", "title", "yearId", "hideProgress", "", "listenAddResponse", "listenAddResponse2", "listenProgressResponse", "listenSpinnerResponse", "listenUpdateResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/profile/fundedresearch/FundedResearchFragment;", "setUp", "showProgress", "AddFundedResearchListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddFundedResearchDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogAddFundedResearchBinding _binding;

    /* renamed from: addFundedResearchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addFundedResearchViewModel;
    private String agency;
    private String amount;
    private String duration;
    private String id;
    private AddFundedResearchListener listener;
    private File pickFile;

    /* renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String title;
    private String yearId;

    /* compiled from: AddFundedResearchDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog$AddFundedResearchListener;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddFundedResearchListener {
        void onDismiss();
    }

    /* compiled from: AddFundedResearchDialog.kt */
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
    public static final AddFundedResearchDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddFundedResearchDialog() {
        final AddFundedResearchDialog addFundedResearchDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addFundedResearchDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addFundedResearchViewModel = FragmentViewModelLazyKt.createViewModelLazy(addFundedResearchDialog, Reflection.getOrCreateKotlinClass(AddFundedResearchViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddFundedResearchViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AddFundedResearchDialog addFundedResearchDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddFundedResearchDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<IndexSpinnerAdapter>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.profile.quality_publication.add.IndexSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final IndexSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addFundedResearchDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(IndexSpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final AddFundedResearchViewModel getAddFundedResearchViewModel() {
        return (AddFundedResearchViewModel) this.addFundedResearchViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogAddFundedResearchBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IndexSpinnerAdapter getSpinnerAdapter2() {
        return (IndexSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* compiled from: AddFundedResearchDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/fundedresearch/add/AddFundedResearchDialog;", "id", "", "title", "agency", ExamSubjectDetailDialogKt.ARG_AMOUNT, TypedValues.TransitionType.S_DURATION, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddFundedResearchDialog newInstance(String id, String title, String agency, String amount, String duration) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(agency, "agency");
            Intrinsics.checkNotNullParameter(amount, "amount");
            Intrinsics.checkNotNullParameter(duration, "duration");
            AddFundedResearchDialog addFundedResearchDialog = new AddFundedResearchDialog();
            Bundle bundle = new Bundle();
            bundle.putString("flag", id);
            bundle.putString(ExamSubjectDetailDialogKt.ARG_AMOUNT, title);
            bundle.putString("url", agency);
            bundle.putString("fine", amount);
            bundle.putString("fixed", duration);
            addFundedResearchDialog.setArguments(bundle);
            return addFundedResearchDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("flag");
            this.title = arguments.getString(ExamSubjectDetailDialogKt.ARG_AMOUNT);
            this.agency = arguments.getString("url");
            this.amount = arguments.getString("fine");
            this.duration = arguments.getString("fixed");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogAddFundedResearchBinding.inflate(inflater, container, false);
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding = get_binding();
        if (dialogAddFundedResearchBinding != null) {
            dialogAddFundedResearchBinding.setAddFundedResearchViewModel(getAddFundedResearchViewModel());
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = get_binding();
        if (dialogAddFundedResearchBinding2 != null) {
            dialogAddFundedResearchBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = get_binding();
        if (dialogAddFundedResearchBinding3 != null) {
            return dialogAddFundedResearchBinding3.getRoot();
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
        TextInputEditText textInputEditText4;
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding = get_binding();
        Spinner spinner = dialogAddFundedResearchBinding != null ? dialogAddFundedResearchBinding.spinnerYear : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinnerResponse();
        listenProgressResponse();
        listenUpdateResponse();
        listenAddResponse();
        listenAddResponse2();
        getAddFundedResearchViewModel().getDropDownData();
        if (!Intrinsics.areEqual(this.id, "")) {
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = get_binding();
            TextView textView4 = dialogAddFundedResearchBinding2 != null ? dialogAddFundedResearchBinding2.addBtn : null;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = get_binding();
            TextView textView5 = dialogAddFundedResearchBinding3 != null ? dialogAddFundedResearchBinding3.updateBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding4 = get_binding();
            TextView textView6 = dialogAddFundedResearchBinding4 != null ? dialogAddFundedResearchBinding4.addBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(0);
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding5 = get_binding();
            TextView textView7 = dialogAddFundedResearchBinding5 != null ? dialogAddFundedResearchBinding5.updateBtn : null;
            if (textView7 != null) {
                textView7.setVisibility(8);
            }
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding6 = get_binding();
        if (dialogAddFundedResearchBinding6 != null && (textInputEditText4 = dialogAddFundedResearchBinding6.etTitle) != null) {
            textInputEditText4.setText(this.title);
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding7 = get_binding();
        if (dialogAddFundedResearchBinding7 != null && (textInputEditText3 = dialogAddFundedResearchBinding7.etAgency) != null) {
            textInputEditText3.setText(this.agency);
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding8 = get_binding();
        if (dialogAddFundedResearchBinding8 != null && (textInputEditText2 = dialogAddFundedResearchBinding8.etAmount) != null) {
            textInputEditText2.setText(this.amount);
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding9 = get_binding();
        if (dialogAddFundedResearchBinding9 != null && (textInputEditText = dialogAddFundedResearchBinding9.etDuration) != null) {
            textInputEditText.setText(this.duration);
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding10 = get_binding();
        Spinner spinner2 = dialogAddFundedResearchBinding10 != null ? dialogAddFundedResearchBinding10.spinnerYear : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    IndexSpinnerAdapter spinnerAdapter2;
                    AddFundedResearchDialog addFundedResearchDialog = AddFundedResearchDialog.this;
                    spinnerAdapter2 = addFundedResearchDialog.getSpinnerAdapter2();
                    addFundedResearchDialog.yearId = String.valueOf(spinnerAdapter2.getSemester(position).getId());
                }
            });
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding11 = get_binding();
        if (dialogAddFundedResearchBinding11 != null && (textView3 = dialogAddFundedResearchBinding11.completionSelect) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddFundedResearchDialog.setUp$lambda$2(AddFundedResearchDialog.this, view);
                }
            });
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding12 = get_binding();
        if (dialogAddFundedResearchBinding12 != null && (textView2 = dialogAddFundedResearchBinding12.addBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddFundedResearchDialog.setUp$lambda$3(AddFundedResearchDialog.this, view);
                }
            });
        }
        DialogAddFundedResearchBinding dialogAddFundedResearchBinding13 = get_binding();
        if (dialogAddFundedResearchBinding13 == null || (textView = dialogAddFundedResearchBinding13.updateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddFundedResearchDialog.setUp$lambda$4(AddFundedResearchDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddFundedResearchDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddFundedResearchDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextView textView;
        TextInputEditText textInputEditText5;
        TextView textView2;
        TextInputEditText textInputEditText6;
        TextView textView3;
        File file;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextView textView4;
        TextInputEditText textInputEditText11;
        TextView textView5;
        TextInputEditText textInputEditText12;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            if (String.valueOf((dialogAddFundedResearchBinding == null || (textView6 = dialogAddFundedResearchBinding.completionFileName) == null) ? null : textView6.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding2 == null || (textInputEditText12 = dialogAddFundedResearchBinding2.etTitle) == null) ? null : textInputEditText12.getText()), "")) {
                        DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
                        if (dialogAddFundedResearchBinding3 == null || (textView5 = dialogAddFundedResearchBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Project Title Cannot be empty");
                        return;
                    }
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding4 == null || (textInputEditText11 = dialogAddFundedResearchBinding4.etAgency) == null) ? null : textInputEditText11.getText()), "")) {
                        DialogAddFundedResearchBinding dialogAddFundedResearchBinding5 = this$0.get_binding();
                        if (dialogAddFundedResearchBinding5 == null || (textView4 = dialogAddFundedResearchBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Funding Agency Cannot be empty");
                        return;
                    }
                    AddFundedResearchViewModel addFundedResearchViewModel = this$0.getAddFundedResearchViewModel();
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding6 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddFundedResearchBinding6 == null || (textInputEditText10 = dialogAddFundedResearchBinding6.etTitle) == null) ? null : textInputEditText10.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding7 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddFundedResearchBinding7 == null || (textInputEditText9 = dialogAddFundedResearchBinding7.etAmount) == null) ? null : textInputEditText9.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding8 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddFundedResearchBinding8 == null || (textInputEditText8 = dialogAddFundedResearchBinding8.etAgency) == null) ? null : textInputEditText8.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding9 = this$0.get_binding();
                    String valueOf4 = String.valueOf((dialogAddFundedResearchBinding9 == null || (textInputEditText7 = dialogAddFundedResearchBinding9.etDuration) == null) ? null : textInputEditText7.getText());
                    String str = this$0.yearId;
                    Intrinsics.checkNotNull(str);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addFundedResearchViewModel.addFundedResearchData(valueOf, valueOf2, valueOf3, valueOf4, str, file);
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding10 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddFundedResearchBinding10 != null ? dialogAddFundedResearchBinding10.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding11 = this$0.get_binding();
                    CardView cardView = dialogAddFundedResearchBinding11 != null ? dialogAddFundedResearchBinding11.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding12 = this$0.get_binding();
                if (dialogAddFundedResearchBinding12 == null || (textView3 = dialogAddFundedResearchBinding12.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100KB");
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding13 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding13 == null || (textInputEditText6 = dialogAddFundedResearchBinding13.etTitle) == null) ? null : textInputEditText6.getText()), "")) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding14 = this$0.get_binding();
                if (dialogAddFundedResearchBinding14 == null || (textView2 = dialogAddFundedResearchBinding14.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Project Title Cannot be empty");
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding15 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding15 == null || (textInputEditText5 = dialogAddFundedResearchBinding15.etAgency) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding16 = this$0.get_binding();
                if (dialogAddFundedResearchBinding16 == null || (textView = dialogAddFundedResearchBinding16.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Funding Agency Cannot be empty");
                return;
            }
            AddFundedResearchViewModel addFundedResearchViewModel2 = this$0.getAddFundedResearchViewModel();
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding17 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddFundedResearchBinding17 == null || (textInputEditText4 = dialogAddFundedResearchBinding17.etTitle) == null) ? null : textInputEditText4.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding18 = this$0.get_binding();
            String valueOf6 = String.valueOf((dialogAddFundedResearchBinding18 == null || (textInputEditText3 = dialogAddFundedResearchBinding18.etAmount) == null) ? null : textInputEditText3.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding19 = this$0.get_binding();
            String valueOf7 = String.valueOf((dialogAddFundedResearchBinding19 == null || (textInputEditText2 = dialogAddFundedResearchBinding19.etAgency) == null) ? null : textInputEditText2.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding20 = this$0.get_binding();
            String valueOf8 = String.valueOf((dialogAddFundedResearchBinding20 == null || (textInputEditText = dialogAddFundedResearchBinding20.etDuration) == null) ? null : textInputEditText.getText());
            String str2 = this$0.yearId;
            Intrinsics.checkNotNull(str2);
            addFundedResearchViewModel2.addFundedResearchData(valueOf5, valueOf6, valueOf7, valueOf8, str2);
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding21 = this$0.get_binding();
            LinearLayout linearLayout2 = dialogAddFundedResearchBinding21 != null ? dialogAddFundedResearchBinding21.completionCard : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(8);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(AddFundedResearchDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextView textView;
        TextInputEditText textInputEditText5;
        TextView textView2;
        TextInputEditText textInputEditText6;
        TextView textView3;
        File file;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextView textView4;
        TextInputEditText textInputEditText11;
        TextView textView5;
        TextInputEditText textInputEditText12;
        TextView textView6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            Editable editable = null;
            editable = null;
            if (String.valueOf((dialogAddFundedResearchBinding == null || (textView6 = dialogAddFundedResearchBinding.completionFileName) == null) ? null : textView6.getText()).length() > 0) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 100) {
                    this$0.setCancelable(false);
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding2 == null || (textInputEditText12 = dialogAddFundedResearchBinding2.etTitle) == null) ? null : textInputEditText12.getText()), "")) {
                        DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
                        if (dialogAddFundedResearchBinding3 == null || (textView5 = dialogAddFundedResearchBinding3.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Project Title Cannot be empty");
                        return;
                    }
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding4 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding4 == null || (textInputEditText11 = dialogAddFundedResearchBinding4.etAgency) == null) ? null : textInputEditText11.getText()), "")) {
                        DialogAddFundedResearchBinding dialogAddFundedResearchBinding5 = this$0.get_binding();
                        if (dialogAddFundedResearchBinding5 == null || (textView4 = dialogAddFundedResearchBinding5.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Funding Agency Cannot be empty");
                        return;
                    }
                    AddFundedResearchViewModel addFundedResearchViewModel = this$0.getAddFundedResearchViewModel();
                    String str = this$0.id;
                    Intrinsics.checkNotNull(str);
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding6 = this$0.get_binding();
                    String valueOf = String.valueOf((dialogAddFundedResearchBinding6 == null || (textInputEditText10 = dialogAddFundedResearchBinding6.etTitle) == null) ? null : textInputEditText10.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding7 = this$0.get_binding();
                    String valueOf2 = String.valueOf((dialogAddFundedResearchBinding7 == null || (textInputEditText9 = dialogAddFundedResearchBinding7.etAmount) == null) ? null : textInputEditText9.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding8 = this$0.get_binding();
                    String valueOf3 = String.valueOf((dialogAddFundedResearchBinding8 == null || (textInputEditText8 = dialogAddFundedResearchBinding8.etAgency) == null) ? null : textInputEditText8.getText());
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding9 = this$0.get_binding();
                    String valueOf4 = String.valueOf((dialogAddFundedResearchBinding9 == null || (textInputEditText7 = dialogAddFundedResearchBinding9.etDuration) == null) ? null : textInputEditText7.getText());
                    String str2 = this$0.yearId;
                    Intrinsics.checkNotNull(str2);
                    File file3 = this$0.pickFile;
                    if (file3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file3;
                    }
                    addFundedResearchViewModel.updateFundedResearchData(str, valueOf, valueOf2, valueOf3, valueOf4, str2, file);
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding10 = this$0.get_binding();
                    LinearLayout linearLayout = dialogAddFundedResearchBinding10 != null ? dialogAddFundedResearchBinding10.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding11 = this$0.get_binding();
                    CardView cardView = dialogAddFundedResearchBinding11 != null ? dialogAddFundedResearchBinding11.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding12 = this$0.get_binding();
                if (dialogAddFundedResearchBinding12 == null || (textView3 = dialogAddFundedResearchBinding12.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 100KB");
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding13 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding13 == null || (textInputEditText6 = dialogAddFundedResearchBinding13.etTitle) == null) ? null : textInputEditText6.getText()), "")) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding14 = this$0.get_binding();
                if (dialogAddFundedResearchBinding14 == null || (textView2 = dialogAddFundedResearchBinding14.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView2, "Project Title Cannot be empty");
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding15 = this$0.get_binding();
            if (Intrinsics.areEqual(String.valueOf((dialogAddFundedResearchBinding15 == null || (textInputEditText5 = dialogAddFundedResearchBinding15.etAgency) == null) ? null : textInputEditText5.getText()), "")) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding16 = this$0.get_binding();
                if (dialogAddFundedResearchBinding16 == null || (textView = dialogAddFundedResearchBinding16.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView, "Funding Agency Cannot be empty");
                return;
            }
            AddFundedResearchViewModel addFundedResearchViewModel2 = this$0.getAddFundedResearchViewModel();
            String str3 = this$0.id;
            Intrinsics.checkNotNull(str3);
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding17 = this$0.get_binding();
            String valueOf5 = String.valueOf((dialogAddFundedResearchBinding17 == null || (textInputEditText4 = dialogAddFundedResearchBinding17.etTitle) == null) ? null : textInputEditText4.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding18 = this$0.get_binding();
            String valueOf6 = String.valueOf((dialogAddFundedResearchBinding18 == null || (textInputEditText3 = dialogAddFundedResearchBinding18.etAmount) == null) ? null : textInputEditText3.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding19 = this$0.get_binding();
            String valueOf7 = String.valueOf((dialogAddFundedResearchBinding19 == null || (textInputEditText2 = dialogAddFundedResearchBinding19.etAgency) == null) ? null : textInputEditText2.getText());
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding20 = this$0.get_binding();
            if (dialogAddFundedResearchBinding20 != null && (textInputEditText = dialogAddFundedResearchBinding20.etDuration) != null) {
                editable = textInputEditText.getText();
            }
            String valueOf8 = String.valueOf(editable);
            String str4 = this$0.yearId;
            Intrinsics.checkNotNull(str4);
            addFundedResearchViewModel2.updateFundedResearchData(str3, valueOf5, valueOf6, valueOf7, valueOf8, str4);
        } catch (Exception unused) {
        }
    }

    private final void listenSpinnerResponse() {
        getAddFundedResearchViewModel().getResponse().observe(getViewLifecycleOwner(), new AddFundedResearchDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PublicationDropDownResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$listenSpinnerResponse$1

            /* compiled from: AddFundedResearchDialog.kt */
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
                IndexSpinnerAdapter spinnerAdapter2;
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddFundedResearchDialog.this.hideProgress();
                    PublicationDropDownResponse data = resource.getData();
                    if (data != null) {
                        try {
                            spinnerAdapter2 = AddFundedResearchDialog.this.getSpinnerAdapter2();
                            spinnerAdapter2.addItems(data.getYears());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    AddFundedResearchDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddFundedResearchDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddFundedResearchDialog.this.hideProgress();
                dialogAddFundedResearchBinding = AddFundedResearchDialog.this.get_binding();
                if (dialogAddFundedResearchBinding == null || (spinner = dialogAddFundedResearchBinding.spinnerYear) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getAddFundedResearchViewModel().getAddResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddFundedResearchDialog.listenAddResponse$lambda$6(AddFundedResearchDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse$lambda$6(AddFundedResearchDialog this$0, Resource resource) {
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
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            if (dialogAddFundedResearchBinding != null && (textView = dialogAddFundedResearchBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddFundedResearchListener addFundedResearchListener = this$0.listener;
            if (addFundedResearchListener != null) {
                addFundedResearchListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
                if (dialogAddFundedResearchBinding2 != null && (addBtn2 = dialogAddFundedResearchBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddFundedResearchListener addFundedResearchListener2 = this$0.listener;
                if (addFundedResearchListener2 != null) {
                    addFundedResearchListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
            if (dialogAddFundedResearchBinding3 != null && (addBtn = dialogAddFundedResearchBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddFundedResearchListener addFundedResearchListener3 = this$0.listener;
            if (addFundedResearchListener3 != null) {
                addFundedResearchListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenAddResponse2() {
        getAddFundedResearchViewModel().getAddResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddFundedResearchDialog.listenAddResponse2$lambda$8(AddFundedResearchDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenAddResponse2$lambda$8(AddFundedResearchDialog this$0, Resource resource) {
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
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            if (dialogAddFundedResearchBinding != null && (textView = dialogAddFundedResearchBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddFundedResearchListener addFundedResearchListener = this$0.listener;
            if (addFundedResearchListener != null) {
                addFundedResearchListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
                if (dialogAddFundedResearchBinding2 != null && (addBtn2 = dialogAddFundedResearchBinding2.addBtn) != null) {
                    Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn2, successResponse.getMessage());
                }
                AddFundedResearchListener addFundedResearchListener2 = this$0.listener;
                if (addFundedResearchListener2 != null) {
                    addFundedResearchListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
            if (dialogAddFundedResearchBinding3 != null && (addBtn = dialogAddFundedResearchBinding3.addBtn) != null) {
                Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                ToastExtKt.showErrorToast(addBtn, successResponse.getMessage());
            }
            AddFundedResearchListener addFundedResearchListener3 = this$0.listener;
            if (addFundedResearchListener3 != null) {
                addFundedResearchListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenUpdateResponse() {
        getAddFundedResearchViewModel().getUpdateResponse2().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddFundedResearchDialog.listenUpdateResponse$lambda$10(AddFundedResearchDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUpdateResponse$lambda$10(AddFundedResearchDialog this$0, Resource resource) {
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
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            if (dialogAddFundedResearchBinding != null && (textView = dialogAddFundedResearchBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddFundedResearchListener addFundedResearchListener = this$0.listener;
            if (addFundedResearchListener != null) {
                addFundedResearchListener.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
                if (dialogAddFundedResearchBinding2 != null && (completionFileName2 = dialogAddFundedResearchBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddFundedResearchListener addFundedResearchListener2 = this$0.listener;
                if (addFundedResearchListener2 != null) {
                    addFundedResearchListener2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
            if (dialogAddFundedResearchBinding3 != null && (completionFileName = dialogAddFundedResearchBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, successResponse.getMessage());
            }
            AddFundedResearchListener addFundedResearchListener3 = this$0.listener;
            if (addFundedResearchListener3 != null) {
                addFundedResearchListener3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddFundedResearchViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.profile.fundedresearch.add.AddFundedResearchDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddFundedResearchDialog.listenProgressResponse$lambda$12(AddFundedResearchDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$12(AddFundedResearchDialog this$0, Resource resource) {
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
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding = this$0.get_binding();
            if (dialogAddFundedResearchBinding == null || (textView = dialogAddFundedResearchBinding.completionFileName) == null) {
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
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogAddFundedResearchBinding2 != null ? dialogAddFundedResearchBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            DialogAddFundedResearchBinding dialogAddFundedResearchBinding3 = this$0.get_binding();
            TextView textView2 = dialogAddFundedResearchBinding3 != null ? dialogAddFundedResearchBinding3.progressText : null;
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
                    DialogAddFundedResearchBinding dialogAddFundedResearchBinding = get_binding();
                    if (dialogAddFundedResearchBinding == null || (completionFileName = dialogAddFundedResearchBinding.completionFileName) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                    ToastExtKt.showErrorToast(completionFileName, "Please select a PDF or JPG file.");
                    return;
                }
                DialogAddFundedResearchBinding dialogAddFundedResearchBinding2 = get_binding();
                TextView textView = dialogAddFundedResearchBinding2 != null ? dialogAddFundedResearchBinding2.completionFileName : null;
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

    public final void setCallBack(FundedResearchFragment context) {
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