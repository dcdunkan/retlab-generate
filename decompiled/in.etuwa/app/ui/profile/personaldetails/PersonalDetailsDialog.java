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

/* JADX INFO: compiled from: PersonalDetailsDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class PersonalDetailsDialog extends BaseDialog implements UpdateAbcDialog.ProfileListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogPersonalDetailsBinding _binding;
    private String abcId;
    private String instruction;
    private ProfileListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: personalDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy personalDetailsViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String video;

    /* JADX INFO: compiled from: PersonalDetailsDialog.kt */
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
                return personalDetailsDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(PersonalDetailsViewModel.class), qualifier, b, null, koinScope);
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
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogPersonalDetailsBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: PersonalDetailsDialog.kt */
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
                PersonalDetailsDialog.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(PersonalDetailsDialog this$0, View view) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String baseUrl = this$0.getPreference().getBaseUrl();
        boolean z = true;
        if ((baseUrl.length() > 0) && StringsKt.contains$default((CharSequence) baseUrl, (CharSequence) "tkmce", false, 2, (Object) null)) {
            String str = this$0.abcId;
            String str2 = this$0.instruction;
            String str3 = this$0.video;
            String str4 = str;
            if (!(str4 == null || str4.length() == 0)) {
                String str5 = str2;
                if (!(str5 == null || str5.length() == 0)) {
                    String str6 = str3;
                    if (str6 != null && str6.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        UpdateAbcDialog updateAbcDialogNewInstance = UpdateAbcDialog.INSTANCE.newInstance(str, str2, str3);
                        updateAbcDialogNewInstance.setCallBack(this$0);
                        updateAbcDialogNewInstance.show(this$0.getChildFragmentManager(), (String) null);
                        return;
                    }
                }
            }
            DialogPersonalDetailsBinding dialogPersonalDetailsBinding = this$0.get_binding();
            if (dialogPersonalDetailsBinding == null || (textView = dialogPersonalDetailsBinding.abcId) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Missing required data");
        }
    }

    private final void listenResponse() {
        getPersonalDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new PersonalDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PersonalDetailsDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ProfileResponse> resource) {
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
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding = PersonalDetailsDialog.this.get_binding();
                    if (dialogPersonalDetailsBinding == null || (textView = dialogPersonalDetailsBinding.admissionNo) == null) {
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
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding2 = personalDetailsDialog.get_binding();
                    TextView textView2 = dialogPersonalDetailsBinding2 != null ? dialogPersonalDetailsBinding2.admissionNo : null;
                    if (textView2 != null) {
                        textView2.setText(data.getAdmission_no());
                    }
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding3 = personalDetailsDialog.get_binding();
                    TextView textView3 = dialogPersonalDetailsBinding3 != null ? dialogPersonalDetailsBinding3.gender : null;
                    if (textView3 != null) {
                        textView3.setText(data.getGender());
                    }
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding4 = personalDetailsDialog.get_binding();
                    TextView textView4 = dialogPersonalDetailsBinding4 != null ? dialogPersonalDetailsBinding4.dob : null;
                    if (textView4 != null) {
                        textView4.setText(data.getDob());
                    }
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding5 = personalDetailsDialog.get_binding();
                    TextView textView5 = dialogPersonalDetailsBinding5 != null ? dialogPersonalDetailsBinding5.regNo : null;
                    if (textView5 != null) {
                        textView5.setText(data.getRegister_no());
                    }
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding6 = personalDetailsDialog.get_binding();
                    TextView textView6 = dialogPersonalDetailsBinding6 != null ? dialogPersonalDetailsBinding6.bloodGroup : null;
                    if (textView6 != null) {
                        textView6.setText(data.getBlood_group());
                    }
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding7 = personalDetailsDialog.get_binding();
                    TextView textView7 = dialogPersonalDetailsBinding7 != null ? dialogPersonalDetailsBinding7.aadharNo : null;
                    if (textView7 == null) {
                        return;
                    }
                    textView7.setText(data.getAdharno());
                }
            }
        }));
    }

    private final void listenAbcResponse() {
        getPersonalDetailsViewModel().getAbcResponse().observe(getViewLifecycleOwner(), new PersonalDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AbcResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog.listenAbcResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog$listenAbcResponse$1$WhenMappings */
            /* JADX INFO: compiled from: PersonalDetailsDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<AbcResponse> resource) {
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
                    DialogPersonalDetailsBinding dialogPersonalDetailsBinding = personalDetailsDialog.get_binding();
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