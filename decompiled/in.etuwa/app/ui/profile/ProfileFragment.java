package in.etuwa.app.ui.profile;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import com.itextpdf.svg.SvgConstants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.R;
import in.etuwa.app.data.model.dash.AbcResponse;
import in.etuwa.app.data.model.dash.ProfileResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentProfileBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.changepassword.ChangePasswordDialog;
import in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog;
import in.etuwa.app.ui.profile.bankdetails.BankDetailsDialog;
import in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog;
import in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog;
import in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog;
import in.etuwa.app.ui.profile.updateabc.UpdateAbcDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
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

/* JADX INFO: compiled from: ProfileFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ProfileFragment extends BaseFragment implements AddUpdateBankDialog.ProfileListener, UpdateAbcDialog.ProfileListener, PersonalDetailsDialog.ProfileListener, ParentDetailsDialog.ProfileListener, ContactDetailsDialog.ProfileListener, ChangePasswordDialog.RemindCounsellingListener, BankDetailsDialog.ProfileListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentProfileBinding _binding;
    private String abcId;
    private boolean flag1;
    private boolean flag2;
    private boolean flag3;
    private boolean flag4;
    private String instruction;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: renamed from: profileViewModel$delegate, reason: from kotlin metadata */
    private final Lazy profileViewModel;
    private String video;

    @JvmStatic
    public static final ProfileFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public ProfileFragment() {
        final ProfileFragment profileFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.profile.ProfileFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return profileFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(profileFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.profileViewModel = FragmentViewModelLazyKt.createViewModelLazy(profileFragment, Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.profile.ProfileFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.profile.ProfileFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ProfileViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final ProfileFragment profileFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.profile.ProfileFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = profileFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final ProfileViewModel getProfileViewModel() {
        return (ProfileViewModel) this.profileViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentProfileBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: ProfileFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/profile/ProfileFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/profile/ProfileFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ProfileFragment newInstance() {
            return new ProfileFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentProfileBinding.inflate(inflater, container, false);
        FragmentProfileBinding fragmentProfileBinding = get_binding();
        if (fragmentProfileBinding != null) {
            fragmentProfileBinding.setProfileViewModel(getProfileViewModel());
        }
        FragmentProfileBinding fragmentProfileBinding2 = get_binding();
        if (fragmentProfileBinding2 != null) {
            fragmentProfileBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentProfileBinding fragmentProfileBinding3 = get_binding();
        if (fragmentProfileBinding3 != null) {
            return fragmentProfileBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        ActionBar supportActionBar;
        hideBaseView();
        getProfileViewModel().getDashData();
        listenResponse();
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        if (appCompatActivity != null && (supportActionBar = appCompatActivity.getSupportActionBar()) != null) {
            supportActionBar.hide();
        }
        getPreference().setNewLogin(false);
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null)) {
            StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null);
        }
        FragmentProfileBinding fragmentProfileBinding = get_binding();
        if (fragmentProfileBinding != null && (linearLayout7 = fragmentProfileBinding.changePwdBtn) != null) {
            linearLayout7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$0(this.f$0, view);
                }
            });
        }
        FragmentProfileBinding fragmentProfileBinding2 = get_binding();
        if (fragmentProfileBinding2 != null && (linearLayout6 = fragmentProfileBinding2.logoutLyt) != null) {
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentProfileBinding fragmentProfileBinding3 = get_binding();
        if (fragmentProfileBinding3 != null && (linearLayout5 = fragmentProfileBinding3.shareAppBtn) != null) {
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "abcdefg", false, 2, (Object) null)) {
            getProfileViewModel().getAbcData();
        }
        FragmentProfileBinding fragmentProfileBinding4 = get_binding();
        if (fragmentProfileBinding4 != null && (linearLayout4 = fragmentProfileBinding4.personalDetailsLyt) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentProfileBinding fragmentProfileBinding5 = get_binding();
        if (fragmentProfileBinding5 != null && (linearLayout3 = fragmentProfileBinding5.btnBank) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentProfileBinding fragmentProfileBinding6 = get_binding();
        if (fragmentProfileBinding6 != null && (linearLayout2 = fragmentProfileBinding6.parentDetailsLyt) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ProfileFragment.setUp$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentProfileBinding fragmentProfileBinding7 = get_binding();
        if (fragmentProfileBinding7 == null || (linearLayout = fragmentProfileBinding7.contactLyt) == null) {
            return;
        }
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.profile.ProfileFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ProfileFragment.setUp$lambda$6(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ChangePasswordDialog changePasswordDialogNewInstance = ChangePasswordDialog.INSTANCE.newInstance();
        changePasswordDialogNewInstance.setCallBack(this$0);
        changePasswordDialogNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.profileLogoutClicked();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context contextRequireContext = this$0.requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        this$0.shareApp(contextRequireContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        PersonalDetailsDialog personalDetailsDialogNewInstance = PersonalDetailsDialog.INSTANCE.newInstance();
        personalDetailsDialogNewInstance.setCallBack(this$0);
        personalDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        BankDetailsDialog bankDetailsDialogNewInstance = BankDetailsDialog.INSTANCE.newInstance();
        bankDetailsDialogNewInstance.setCallBack(this$0);
        bankDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ParentDetailsDialog parentDetailsDialogNewInstance = ParentDetailsDialog.INSTANCE.newInstance();
        parentDetailsDialogNewInstance.setCallBack(this$0);
        parentDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(ProfileFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        ContactDetailsDialog contactDetailsDialogNewInstance = ContactDetailsDialog.INSTANCE.newInstance();
        contactDetailsDialogNewInstance.setCallBack(this$0);
        contactDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }

    public final void shareApp(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            intent.putExtra("android.intent.extra.SUBJECT", "Check out this amazing app!");
            intent.putExtra("android.intent.extra.TEXT", "Download and try our app:\n" + ("https://play.google.com/store/apps/details?id=" + context.getPackageName()));
            context.startActivity(Intent.createChooser(intent, "Share App via"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void listenResponse() {
        getProfileViewModel().getResponse().observe(getViewLifecycleOwner(), new ProfileFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ProfileResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.ProfileFragment.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.ProfileFragment$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ProfileFragment.kt */
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
                        ProfileFragment.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ProfileFragment.this.hideProgress();
                        ProfileFragment.this.showBaseView();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        ProfileFragment.this.hideProgress();
                        ProfileFragment.this.showBaseView();
                        return;
                    }
                }
                ProfileFragment.this.hideProgress();
                ProfileResponse data = resource.getData();
                if (data != null) {
                    ProfileFragment profileFragment = ProfileFragment.this;
                    profileFragment.showBaseView();
                    if (data.getEdit_profile()) {
                        data.getProfile_edit_live();
                    }
                    if (!Intrinsics.areEqual(data.getBankdetail_status(), "verified") && ((!Intrinsics.areEqual(data.getBank_name(), "") || (StringsKt.contains$default((CharSequence) profileFragment.getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) profileFragment.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null))) && !Intrinsics.areEqual(data.getBank_name(), "") && StringsKt.contains$default((CharSequence) profileFragment.getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null))) {
                        StringsKt.contains$default((CharSequence) profileFragment.getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null);
                    }
                    if (profileFragment.getPreference().getUserImg().length() > 0) {
                        RequestCreator requestCreatorCenterCrop = Picasso.get().load(profileFragment.getPreference().getUserImg()).placeholder(R.drawable.ic_user_profile).error(R.drawable.ic_user_profile).resize(108, 108).centerCrop();
                        FragmentProfileBinding fragmentProfileBinding = profileFragment.get_binding();
                        CircleImageView circleImageView = fragmentProfileBinding != null ? fragmentProfileBinding.profileImage : null;
                        Intrinsics.checkNotNull(circleImageView);
                        requestCreatorCenterCrop.into(circleImageView);
                    }
                    FragmentProfileBinding fragmentProfileBinding2 = profileFragment.get_binding();
                    if (fragmentProfileBinding2 != null && (textView = fragmentProfileBinding2.nameTv) != null) {
                        textView.setText(data.getName());
                    }
                    FragmentProfileBinding fragmentProfileBinding3 = profileFragment.get_binding();
                    TextView textView2 = fragmentProfileBinding3 != null ? fragmentProfileBinding3.emailTv : null;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setText(data.getEmail());
                }
            }
        }));
    }

    private final void listenAbcResponse() {
        getProfileViewModel().getAbcResponse().observe(getViewLifecycleOwner(), new ProfileFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends AbcResponse>, Unit>() { // from class: in.etuwa.app.ui.profile.ProfileFragment.listenAbcResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.profile.ProfileFragment$listenAbcResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ProfileFragment.kt */
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
                if (i == 1) {
                    ProfileFragment.this.hideProgress();
                    AbcResponse data = resource.getData();
                    if (data != null) {
                        ProfileFragment profileFragment = ProfileFragment.this;
                        profileFragment.showBaseView();
                        profileFragment.abcId = data.getAbc_id();
                        profileFragment.instruction = data.getInstructions();
                        profileFragment.video = data.getVideo();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ProfileFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ProfileFragment.this.hideProgress();
                    ProfileFragment.this.showBaseView();
                } else {
                    if (i != 4) {
                        return;
                    }
                    ProfileFragment.this.hideProgress();
                    ProfileFragment.this.showBaseView();
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.profile.addupdatebank.AddUpdateBankDialog.ProfileListener, in.etuwa.app.ui.profile.updateabc.UpdateAbcDialog.ProfileListener, in.etuwa.app.ui.profile.personaldetails.PersonalDetailsDialog.ProfileListener, in.etuwa.app.ui.profile.parentdetails.ParentDetailsDialog.ProfileListener, in.etuwa.app.ui.profile.contactdetails.ContactDetailsDialog.ProfileListener, in.etuwa.app.ui.changepassword.ChangePasswordDialog.RemindCounsellingListener
    public void dismiss() {
        getProfileViewModel().getDashData();
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "tkmce", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "engnr", false, 2, (Object) null)) {
            getProfileViewModel().getAbcData();
        }
    }
}