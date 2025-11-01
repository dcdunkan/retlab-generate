package in.etuwa.app.ui.message.reply;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.ReplyDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ReplyDialog.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u001a\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010!\u001a\u00020\u0013H\u0014J\b\u0010\"\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lin/etuwa/app/ui/message/reply/ReplyDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/ReplyDialogBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ReplyDialogBinding;", "from", "", "id", "replyViewModel", "Lin/etuwa/app/ui/message/reply/ReplyViewModel;", "getReplyViewModel", "()Lin/etuwa/app/ui/message/reply/ReplyViewModel;", "replyViewModel$delegate", "Lkotlin/Lazy;", "senderId", "hideProgress", "", "listenManagerResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReplyDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ReplyDialogBinding _binding;
    private String from;
    private String id;

    /* renamed from: replyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy replyViewModel;
    private String senderId;

    /* compiled from: ReplyDialog.kt */
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
    public static final ReplyDialog newInstance(String str, String str2, String str3) {
        return INSTANCE.newInstance(str, str2, str3);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ReplyDialog() {
        final ReplyDialog replyDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.message.reply.ReplyDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(replyDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.replyViewModel = FragmentViewModelLazyKt.createViewModelLazy(replyDialog, Reflection.getOrCreateKotlinClass(ReplyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.message.reply.ReplyDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.message.reply.ReplyDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ReplyViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ReplyViewModel getReplyViewModel() {
        return (ReplyViewModel) this.replyViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ReplyDialogBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ReplyDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/message/reply/ReplyDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/message/reply/ReplyDialog;", "id", "", "senderId", "from", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReplyDialog newInstance(String id, String senderId, String from) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(senderId, "senderId");
            Intrinsics.checkNotNullParameter(from, "from");
            ReplyDialog replyDialog = new ReplyDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putString(ReplyDialogKt.ARG_SENDER_ID, senderId);
            bundle.putString("from", from);
            replyDialog.setArguments(bundle);
            return replyDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.senderId = arguments.getString(ReplyDialogKt.ARG_SENDER_ID);
            this.from = arguments.getString("from");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ReplyDialogBinding.inflate(inflater, container, false);
        ReplyDialogBinding replyDialogBinding = get_binding();
        if (replyDialogBinding != null) {
            replyDialogBinding.setReplyViewModel(getReplyViewModel());
        }
        ReplyDialogBinding replyDialogBinding2 = get_binding();
        if (replyDialogBinding2 != null) {
            replyDialogBinding2.setLifecycleOwner(this);
        }
        ReplyDialogBinding replyDialogBinding3 = get_binding();
        if (replyDialogBinding3 != null) {
            return replyDialogBinding3.getRoot();
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
        listenManagerResponse();
        ReplyDialogBinding replyDialogBinding = get_binding();
        TextView textView2 = replyDialogBinding != null ? replyDialogBinding.tvFrom : null;
        if (textView2 != null) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Resources resources = getResources();
            int i = R.string.reply_to;
            Object[] objArr = new Object[1];
            String str = this.from;
            objArr[0] = str != null ? StringsKt.capitalize(str) : null;
            String string = resources.getString(i, objArr);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…y_to, from?.capitalize())");
            String format = String.format(string, Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
        }
        ReplyDialogBinding replyDialogBinding2 = get_binding();
        if (replyDialogBinding2 == null || (textView = replyDialogBinding2.replyBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.message.reply.ReplyDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReplyDialog.setUp$lambda$1(ReplyDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ReplyDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReplyDialogBinding replyDialogBinding = this$0.get_binding();
        Editable editable = null;
        editable = null;
        if (Intrinsics.areEqual(String.valueOf((replyDialogBinding == null || (textInputEditText2 = replyDialogBinding.etReplyMsg) == null) ? null : textInputEditText2.getText()), "")) {
            ReplyDialogBinding replyDialogBinding2 = this$0.get_binding();
            TextInputEditText textInputEditText3 = replyDialogBinding2 != null ? replyDialogBinding2.etReplyMsg : null;
            if (textInputEditText3 == null) {
                return;
            }
            textInputEditText3.setError(this$0.getString(R.string.error_reply));
            return;
        }
        ReplyViewModel replyViewModel = this$0.getReplyViewModel();
        String str = this$0.senderId;
        String str2 = this$0.id;
        ReplyDialogBinding replyDialogBinding3 = this$0.get_binding();
        if (replyDialogBinding3 != null && (textInputEditText = replyDialogBinding3.etReplyMsg) != null) {
            editable = textInputEditText.getText();
        }
        replyViewModel.composeMsg(str, str2, String.valueOf(editable));
    }

    private final void listenManagerResponse() {
        getReplyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.message.reply.ReplyDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReplyDialog.listenManagerResponse$lambda$4(ReplyDialog.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenManagerResponse$lambda$4(ReplyDialog this$0, Resource resource) {
        TextInputEditText etReplyMsg;
        ReplyDialogBinding replyDialogBinding;
        TextInputEditText etReplyMsg2;
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SuccessResponse successResponse = (SuccessResponse) resource.getData();
            if (successResponse != null) {
                ReplyDialogBinding replyDialogBinding2 = this$0.get_binding();
                if (replyDialogBinding2 != null && (etReplyMsg = replyDialogBinding2.etReplyMsg) != null) {
                    Intrinsics.checkNotNullExpressionValue(etReplyMsg, "etReplyMsg");
                    ToastExtKt.showSuccessToast(etReplyMsg, successResponse.getMessage());
                }
                this$0.dismiss();
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            SuccessResponse successResponse2 = (SuccessResponse) resource.getData();
            if (successResponse2 == null || (replyDialogBinding = this$0.get_binding()) == null || (etReplyMsg2 = replyDialogBinding.etReplyMsg) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(etReplyMsg2, "etReplyMsg");
            ToastExtKt.showErrorToast(etReplyMsg2, successResponse2.getMessage());
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        ReplyDialogBinding replyDialogBinding3 = this$0.get_binding();
        if (replyDialogBinding3 == null || (textInputEditText = replyDialogBinding3.etReplyMsg) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textInputEditText, message);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}