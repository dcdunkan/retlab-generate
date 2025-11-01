package in.etuwa.app.ui.profile.contactdetails;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.databinding.DialogContactDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: ContactDetailsDialog.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010+\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020,J\b\u0010-\u001a\u00020\u0017H\u0014J\b\u0010.\u001a\u00020\u0017H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogContactDetailsBinding;", "abcId", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogContactDetailsBinding;", "contactDetailsViewModel", "Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsViewModel;", "getContactDetailsViewModel", "()Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsViewModel;", "contactDetailsViewModel$delegate", "Lkotlin/Lazy;", "instruction", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsDialog$ProfileListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "video", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/profile/ProfileFragment;", "setUp", "showProgress", "Companion", "ProfileListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactDetailsDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogContactDetailsBinding _binding;
    private String abcId;

    /* renamed from: contactDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy contactDetailsViewModel;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;
    private String video;

    /* compiled from: ContactDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsDialog$ProfileListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void dismiss();
    }

    @JvmStatic
    public static final ContactDetailsDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ContactDetailsDialog() {
        final ContactDetailsDialog contactDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(contactDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.contactDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(contactDetailsDialog, Reflection.getOrCreateKotlinClass(ContactDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ContactDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final ContactDetailsViewModel getContactDetailsViewModel() {
        return (ContactDetailsViewModel) this.contactDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogContactDetailsBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ContactDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/contactdetails/ContactDetailsDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ContactDetailsDialog newInstance() {
            ContactDetailsDialog contactDetailsDialog = new ContactDetailsDialog();
            contactDetailsDialog.setArguments(new Bundle());
            return contactDetailsDialog;
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
        this._binding = DialogContactDetailsBinding.inflate(inflater, container, false);
        DialogContactDetailsBinding dialogContactDetailsBinding = get_binding();
        if (dialogContactDetailsBinding != null) {
            dialogContactDetailsBinding.setContactDetailsViewModel(getContactDetailsViewModel());
        }
        DialogContactDetailsBinding dialogContactDetailsBinding2 = get_binding();
        if (dialogContactDetailsBinding2 != null) {
            dialogContactDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogContactDetailsBinding dialogContactDetailsBinding3 = get_binding();
        if (dialogContactDetailsBinding3 != null) {
            return dialogContactDetailsBinding3.getRoot();
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
        listenResponse();
        getContactDetailsViewModel().getDashData();
    }

    private final void listenResponse() {
        getContactDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new ContactDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog$listenResponse$1

            /* compiled from: ContactDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ProfileResponse> resource) {
                invoke2((Resource<ProfileResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ProfileResponse> resource) {
                DialogContactDetailsBinding dialogContactDetailsBinding;
                DialogContactDetailsBinding dialogContactDetailsBinding2;
                DialogContactDetailsBinding dialogContactDetailsBinding3;
                DialogContactDetailsBinding dialogContactDetailsBinding4;
                DialogContactDetailsBinding dialogContactDetailsBinding5;
                DialogContactDetailsBinding dialogContactDetailsBinding6;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ContactDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ContactDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ContactDetailsDialog.this.hideProgress();
                    dialogContactDetailsBinding6 = ContactDetailsDialog.this.get_binding();
                    if (dialogContactDetailsBinding6 == null || (textView = dialogContactDetailsBinding6.number) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ContactDetailsDialog.this.hideProgress();
                ProfileResponse data = resource.getData();
                if (data != null) {
                    ContactDetailsDialog contactDetailsDialog = ContactDetailsDialog.this;
                    dialogContactDetailsBinding = contactDetailsDialog.get_binding();
                    TextView textView2 = dialogContactDetailsBinding != null ? dialogContactDetailsBinding.address : null;
                    if (textView2 != null) {
                        textView2.setText(data.getAddress1() + "           " + data.getAddress2() + "           " + data.getAddress3());
                    }
                    dialogContactDetailsBinding2 = contactDetailsDialog.get_binding();
                    TextView textView3 = dialogContactDetailsBinding2 != null ? dialogContactDetailsBinding2.district : null;
                    if (textView3 != null) {
                        textView3.setText(data.getDistrict());
                    }
                    dialogContactDetailsBinding3 = contactDetailsDialog.get_binding();
                    TextView textView4 = dialogContactDetailsBinding3 != null ? dialogContactDetailsBinding3.pin : null;
                    if (textView4 != null) {
                        textView4.setText(data.getPin());
                    }
                    dialogContactDetailsBinding4 = contactDetailsDialog.get_binding();
                    TextView textView5 = dialogContactDetailsBinding4 != null ? dialogContactDetailsBinding4.state : null;
                    if (textView5 != null) {
                        textView5.setText(data.getState());
                    }
                    dialogContactDetailsBinding5 = contactDetailsDialog.get_binding();
                    TextView textView6 = dialogContactDetailsBinding5 != null ? dialogContactDetailsBinding5.number : null;
                    if (textView6 == null) {
                        return;
                    }
                    textView6.setText(data.getPhone_home());
                }
            }
        }));
    }

    public final void setCallBack(ProfileFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ProfileListener profileListener = this.listener;
        if (profileListener != null) {
            profileListener.dismiss();
        }
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