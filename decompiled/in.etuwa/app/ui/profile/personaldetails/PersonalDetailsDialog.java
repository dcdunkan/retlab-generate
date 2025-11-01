package in.etuwa.app.ui.profile.personaldetails;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogPersonalDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.profile.ProfileFragment;
import in.etuwa.app.ui.profile.updateabc.UpdateAbcDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: PersonalDetailsDialog.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000267B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020/H\u0016J\u001a\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020'2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u000e\u00102\u001a\u00020\u001d2\u0006\u0010!\u001a\u000203J\b\u00104\u001a\u00020\u001dH\u0014J\b\u00105\u001a\u00020\u001dH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/profile/updateabc/UpdateAbcDialog$ProfileListener;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogPersonalDetailsBinding;", "abcId", "", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogPersonalDetailsBinding;", "instruction", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsDialog$ProfileListener;", "listener2", "Lin/etuwa/app/helper/MainCallBackListener;", "personalDetailsViewModel", "Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsViewModel;", "getPersonalDetailsViewModel", "()Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsViewModel;", "personalDetailsViewModel$delegate", "Lkotlin/Lazy;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "video", "hideProgress", "", "listenAbcResponse", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/profile/ProfileFragment;", "setUp", "showProgress", "Companion", "ProfileListener", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PersonalDetailsDialog extends BaseDialog implements UpdateAbcDialog.ProfileListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogPersonalDetailsBinding _binding;
    private String abcId;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* renamed from: personalDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy personalDetailsViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String video;

    /* compiled from: PersonalDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsDialog$ProfileListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ProfileListener {
        void dismiss();
    }

    @JvmStatic
    public static final PersonalDetailsDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public PersonalDetailsDialog() {
        final PersonalDetailsDialog personalDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(personalDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.personalDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(personalDetailsDialog, Reflection.getOrCreateKotlinClass(PersonalDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(PersonalDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final PersonalDetailsDialog personalDetailsDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = personalDetailsDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final PersonalDetailsViewModel getPersonalDetailsViewModel() {
        return (PersonalDetailsViewModel) this.personalDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogPersonalDetailsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: PersonalDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/personaldetails/PersonalDetailsDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PersonalDetailsDialog newInstance() {
            PersonalDetailsDialog personalDetailsDialog = new PersonalDetailsDialog();
            personalDetailsDialog.setArguments(new Bundle());
            return personalDetailsDialog;
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
        this._binding = DialogPersonalDetailsBinding.inflate(inflater, container, false);
        DialogPersonalDetailsBinding dialogPersonalDetailsBinding = get_binding();
        if (dialogPersonalDetailsBinding != null) {
            dialogPersonalDetailsBinding.setPersonalDetailsViewModel(getPersonalDetailsViewModel());
        }
        DialogPersonalDetailsBinding dialogPersonalDetailsBinding2 = get_binding();
        if (dialogPersonalDetailsBinding2 != null) {
            dialogPersonalDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogPersonalDetailsBinding dialogPersonalDetailsBinding3 = get_binding();
        if (dialogPersonalDetailsBinding3 != null) {
            return dialogPersonalDetailsBinding3.getRoot();
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
        listenResponse();
        listenAbcResponse();
        getPersonalDetailsViewModel().getDashData();
        getPersonalDetailsViewModel().getAbcData();
        DialogPersonalDetailsBinding dialogPersonalDetailsBinding = get_binding();
        if (dialogPersonalDetailsBinding == null || (textView = dialogPersonalDetailsBinding.abcId) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PersonalDetailsDialog.setUp$lambda$1(PersonalDetailsDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PersonalDetailsDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (StringsKt.contains$default((CharSequence) this$0.getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null)) {
            FragmentManager childFragmentManager = this$0.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            UpdateAbcDialog.Companion companion = UpdateAbcDialog.INSTANCE;
            String str = this$0.abcId;
            Intrinsics.checkNotNull(str);
            String str2 = this$0.instruction;
            Intrinsics.checkNotNull(str2);
            String str3 = this$0.video;
            Intrinsics.checkNotNull(str3);
            UpdateAbcDialog newInstance = companion.newInstance(str, str2, str3);
            newInstance.setCallBack(this$0);
            newInstance.show(childFragmentManager, (String) null);
        }
    }

    private final void listenResponse() {
        getPersonalDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new PersonalDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$listenResponse$1

            /* compiled from: PersonalDetailsDialog.kt */
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
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding2;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding3;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding4;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding5;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding6;
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding7;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PersonalDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        PersonalDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    PersonalDetailsDialog.this.hideProgress();
                    dialogPersonalDetailsBinding7 = PersonalDetailsDialog.this.get_binding();
                    if (dialogPersonalDetailsBinding7 == null || (textView = dialogPersonalDetailsBinding7.admissionNo) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                PersonalDetailsDialog.this.hideProgress();
                ProfileResponse data = resource.getData();
                if (data != null) {
                    PersonalDetailsDialog personalDetailsDialog = PersonalDetailsDialog.this;
                    dialogPersonalDetailsBinding = personalDetailsDialog.get_binding();
                    TextView textView2 = dialogPersonalDetailsBinding != null ? dialogPersonalDetailsBinding.admissionNo : null;
                    if (textView2 != null) {
                        textView2.setText(data.getAdmission_no());
                    }
                    dialogPersonalDetailsBinding2 = personalDetailsDialog.get_binding();
                    TextView textView3 = dialogPersonalDetailsBinding2 != null ? dialogPersonalDetailsBinding2.gender : null;
                    if (textView3 != null) {
                        textView3.setText(data.getGender());
                    }
                    dialogPersonalDetailsBinding3 = personalDetailsDialog.get_binding();
                    TextView textView4 = dialogPersonalDetailsBinding3 != null ? dialogPersonalDetailsBinding3.dob : null;
                    if (textView4 != null) {
                        textView4.setText(data.getDob());
                    }
                    dialogPersonalDetailsBinding4 = personalDetailsDialog.get_binding();
                    TextView textView5 = dialogPersonalDetailsBinding4 != null ? dialogPersonalDetailsBinding4.regNo : null;
                    if (textView5 != null) {
                        textView5.setText(data.getRegister_no());
                    }
                    dialogPersonalDetailsBinding5 = personalDetailsDialog.get_binding();
                    TextView textView6 = dialogPersonalDetailsBinding5 != null ? dialogPersonalDetailsBinding5.bloodGroup : null;
                    if (textView6 != null) {
                        textView6.setText(data.getBlood_group());
                    }
                    dialogPersonalDetailsBinding6 = personalDetailsDialog.get_binding();
                    TextView textView7 = dialogPersonalDetailsBinding6 != null ? dialogPersonalDetailsBinding6.aadharNo : null;
                    if (textView7 == null) {
                        return;
                    }
                    textView7.setText(data.getAdharno());
                }
            }
        }));
    }

    private final void listenAbcResponse() {
        getPersonalDetailsViewModel().getAbcResponse().observe(getViewLifecycleOwner(), new PersonalDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AbcResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$listenAbcResponse$1

            /* compiled from: PersonalDetailsDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends AbcResponse> resource) {
                invoke2((Resource<AbcResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AbcResponse> resource) {
                DialogPersonalDetailsBinding dialogPersonalDetailsBinding;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        PersonalDetailsDialog.this.showProgress();
                        return;
                    } else if (i == 3) {
                        PersonalDetailsDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        PersonalDetailsDialog.this.hideProgress();
                        return;
                    }
                }
                PersonalDetailsDialog.this.hideProgress();
                AbcResponse data = resource.getData();
                if (data != null) {
                    PersonalDetailsDialog personalDetailsDialog = PersonalDetailsDialog.this;
                    dialogPersonalDetailsBinding = personalDetailsDialog.get_binding();
                    TextView textView = dialogPersonalDetailsBinding != null ? dialogPersonalDetailsBinding.abcId : null;
                    if (textView != null) {
                        textView.setText(data.getAbc_id());
                    }
                    personalDetailsDialog.abcId = data.getAbc_id();
                    personalDetailsDialog.instruction = data.getInstructions();
                    personalDetailsDialog.video = data.getVideo();
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