package in.etuwa.app.ui.examregistration.examsubjects.view.verify;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.DialogVerifyAbcIdBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.examregistration.examsubjects.view.ExamViewFragment;
import in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AbcIdVerifyDialog.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u000234B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020\u001bH\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020,H\u0016J\u001a\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u000e\u0010/\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u000200J\b\u00101\u001a\u00020\u001bH\u0014J\b\u00102\u001a\u00020\u001bH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogVerifyAbcIdBinding;", "abcIdVerifyViewModel", "Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyViewModel;", "getAbcIdVerifyViewModel", "()Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyViewModel;", "abcIdVerifyViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogVerifyAbcIdBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "id", "", "instructions", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyDialog$ProfileListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "video", "hideProgress", "", "listenVerifyResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/examregistration/examsubjects/view/ExamViewFragment;", "setUp", "showProgress", "Companion", "ProfileListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AbcIdVerifyDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogVerifyAbcIdBinding _binding;

    /* renamed from: abcIdVerifyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy abcIdVerifyViewModel;
    private ArrayList<DownloadModel> downList;
    private String id;
    private String instructions;
    private ProfileListener listener;
    private MainCallBackListener listener2;
    private String video;

    /* compiled from: AbcIdVerifyDialog.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyDialog$ProfileListener;", "", "getVerifyResult", "", "flag", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void getVerifyResult(boolean flag);
    }

    @JvmStatic
    public static final AbcIdVerifyDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AbcIdVerifyDialog() {
        final AbcIdVerifyDialog abcIdVerifyDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(abcIdVerifyDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.abcIdVerifyViewModel = FragmentViewModelLazyKt.createViewModelLazy(abcIdVerifyDialog, Reflection.getOrCreateKotlinClass(AbcIdVerifyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AbcIdVerifyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.downList = new ArrayList<>();
    }

    private final AbcIdVerifyViewModel getAbcIdVerifyViewModel() {
        return (AbcIdVerifyViewModel) this.abcIdVerifyViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogVerifyAbcIdBinding get_binding() {
        return this._binding;
    }

    /* compiled from: AbcIdVerifyDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/examregistration/examsubjects/view/verify/AbcIdVerifyDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AbcIdVerifyDialog newInstance() {
            AbcIdVerifyDialog abcIdVerifyDialog = new AbcIdVerifyDialog();
            abcIdVerifyDialog.setArguments(new Bundle());
            return abcIdVerifyDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArguments();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogVerifyAbcIdBinding.inflate(inflater, container, false);
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding = get_binding();
        if (dialogVerifyAbcIdBinding != null) {
            dialogVerifyAbcIdBinding.setAbcIdVerifyViewModel(getAbcIdVerifyViewModel());
        }
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding2 = get_binding();
        if (dialogVerifyAbcIdBinding2 != null) {
            dialogVerifyAbcIdBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding3 = get_binding();
        if (dialogVerifyAbcIdBinding3 != null) {
            return dialogVerifyAbcIdBinding3.getRoot();
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
        listenVerifyResponse();
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding = get_binding();
        if (dialogVerifyAbcIdBinding != null && (textView2 = dialogVerifyAbcIdBinding.createBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbcIdVerifyDialog.setUp$lambda$1(AbcIdVerifyDialog.this, view);
                }
            });
        }
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding2 = get_binding();
        if (dialogVerifyAbcIdBinding2 == null || (textView = dialogVerifyAbcIdBinding2.cancelBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AbcIdVerifyDialog.setUp$lambda$2(AbcIdVerifyDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AbcIdVerifyDialog this$0, View view) {
        EditText editText;
        TextView textView;
        EditText editText2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding = this$0.get_binding();
        Editable editable = null;
        if (Intrinsics.areEqual(String.valueOf((dialogVerifyAbcIdBinding == null || (editText2 = dialogVerifyAbcIdBinding.etSeriesDetails) == null) ? null : editText2.getText()), "")) {
            DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding2 = this$0.get_binding();
            if (dialogVerifyAbcIdBinding2 == null || (textView = dialogVerifyAbcIdBinding2.createBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Please enter ABC ID to continue.");
            return;
        }
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding3 = this$0.get_binding();
        TextView textView2 = dialogVerifyAbcIdBinding3 != null ? dialogVerifyAbcIdBinding3.createBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        AbcIdVerifyViewModel abcIdVerifyViewModel = this$0.getAbcIdVerifyViewModel();
        DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding4 = this$0.get_binding();
        if (dialogVerifyAbcIdBinding4 != null && (editText = dialogVerifyAbcIdBinding4.etSeriesDetails) != null) {
            editable = editText.getText();
        }
        abcIdVerifyViewModel.getVerifyAbcData(String.valueOf(editable));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AbcIdVerifyDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final void listenVerifyResponse() {
        getAbcIdVerifyViewModel().getResponse().observe(getViewLifecycleOwner(), new AbcIdVerifyDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.examregistration.examsubjects.view.verify.AbcIdVerifyDialog$listenVerifyResponse$1

            /* compiled from: AbcIdVerifyDialog.kt */
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
                DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding;
                DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding2;
                TextView createBtn;
                AbcIdVerifyDialog.ProfileListener profileListener;
                DialogVerifyAbcIdBinding dialogVerifyAbcIdBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AbcIdVerifyDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AbcIdVerifyDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AbcIdVerifyDialog.this.hideProgress();
                    dialogVerifyAbcIdBinding3 = AbcIdVerifyDialog.this.get_binding();
                    if (dialogVerifyAbcIdBinding3 == null || (textView = dialogVerifyAbcIdBinding3.createBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AbcIdVerifyDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AbcIdVerifyDialog abcIdVerifyDialog = AbcIdVerifyDialog.this;
                    if (data.getSuccess()) {
                        profileListener = abcIdVerifyDialog.listener;
                        if (profileListener != null) {
                            profileListener.getVerifyResult(true);
                        }
                        abcIdVerifyDialog.dismiss();
                        return;
                    }
                    dialogVerifyAbcIdBinding = abcIdVerifyDialog.get_binding();
                    TextView textView2 = dialogVerifyAbcIdBinding != null ? dialogVerifyAbcIdBinding.createBtn : null;
                    if (textView2 != null) {
                        textView2.setVisibility(0);
                    }
                    dialogVerifyAbcIdBinding2 = abcIdVerifyDialog.get_binding();
                    if (dialogVerifyAbcIdBinding2 == null || (createBtn = dialogVerifyAbcIdBinding2.createBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(createBtn, "createBtn");
                    ToastExtKt.showErrorToast(createBtn, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(ExamViewFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}