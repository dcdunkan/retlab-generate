package in.etuwa.app.ui.hostel.mess.booknow;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.mess.MessMenuResponse;
import in.etuwa.app.data.model.mess.MessTypeResponse;
import in.etuwa.app.databinding.DialogMessBookingBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.mess.MessFragment;
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
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: MessBookingDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class MessBookingDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogMessBookingBinding _binding;
    private BookMessListener listener;
    private int maxQty;
    private String menu;

    /* JADX INFO: renamed from: messBookingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy messBookingViewModel;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;
    private String type;

    /* JADX INFO: compiled from: MessBookingDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/booknow/MessBookingDialog$BookMessListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BookMessListener {
        void dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maxQuantityDialog$lambda$2(DialogInterface dialogInterface, int i) {
    }

    @JvmStatic
    public static final MessBookingDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public MessBookingDialog() {
        final MessBookingDialog messBookingDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return messBookingDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(messBookingDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.messBookingViewModel = FragmentViewModelLazyKt.createViewModelLazy(messBookingDialog, Reflection.getOrCreateKotlinClass(MessBookingViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(MessBookingViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        this.menu = "";
        final MessBookingDialog messBookingDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MessMenuSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.mess.booknow.MessMenuSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MessMenuSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = messBookingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MessMenuSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$spinnerAdapter2$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b3 = 0 == true ? 1 : 0;
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<MessTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.mess.booknow.MessTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final MessTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = messBookingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(MessTypeSpinnerAdapter.class), b3, function03);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessBookingViewModel getMessBookingViewModel() {
        return (MessBookingViewModel) this.messBookingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogMessBookingBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessMenuSpinnerAdapter getSpinnerAdapter() {
        return (MessMenuSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessTypeSpinnerAdapter getSpinnerAdapter2() {
        return (MessTypeSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: compiled from: MessBookingDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/mess/booknow/MessBookingDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/mess/booknow/MessBookingDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MessBookingDialog newInstance() {
            return new MessBookingDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogMessBookingBinding.inflate(inflater, container, false);
        DialogMessBookingBinding dialogMessBookingBinding = get_binding();
        if (dialogMessBookingBinding != null) {
            dialogMessBookingBinding.setMessBookingViewModel(getMessBookingViewModel());
        }
        DialogMessBookingBinding dialogMessBookingBinding2 = get_binding();
        if (dialogMessBookingBinding2 != null) {
            dialogMessBookingBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogMessBookingBinding dialogMessBookingBinding3 = get_binding();
        if (dialogMessBookingBinding3 != null) {
            return dialogMessBookingBinding3.getRoot();
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
        DialogMessBookingBinding dialogMessBookingBinding = get_binding();
        Spinner spinner = dialogMessBookingBinding != null ? dialogMessBookingBinding.spinnerMessMenu : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogMessBookingBinding dialogMessBookingBinding2 = get_binding();
        Spinner spinner2 = dialogMessBookingBinding2 != null ? dialogMessBookingBinding2.spinnerMessType : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        listenSpinner();
        listenSpinner2();
        listenBookResponse();
        getMessBookingViewModel().getMessType();
        DialogMessBookingBinding dialogMessBookingBinding3 = get_binding();
        Spinner spinner3 = dialogMessBookingBinding3 != null ? dialogMessBookingBinding3.spinnerMessMenu : null;
        if (spinner3 != null) {
            spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    MessBookingDialog messBookingDialog = MessBookingDialog.this;
                    messBookingDialog.type = messBookingDialog.getSpinnerAdapter().getType(position).getId();
                    MessBookingDialog.this.getMessBookingViewModel().getMessMenuType(MessBookingDialog.this.type);
                }
            });
        }
        DialogMessBookingBinding dialogMessBookingBinding4 = get_binding();
        Spinner spinner4 = dialogMessBookingBinding4 != null ? dialogMessBookingBinding4.spinnerMessType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    TextView textView2;
                    MessBookingDialog messBookingDialog = MessBookingDialog.this;
                    messBookingDialog.menu = messBookingDialog.getSpinnerAdapter2().getType(position).getId();
                    MessBookingDialog messBookingDialog2 = MessBookingDialog.this;
                    messBookingDialog2.maxQty = Integer.parseInt(messBookingDialog2.getSpinnerAdapter2().getType(position).getMax_qty());
                    DialogMessBookingBinding dialogMessBookingBinding5 = MessBookingDialog.this.get_binding();
                    if (dialogMessBookingBinding5 == null || (textView2 = dialogMessBookingBinding5.maxQtyTv) == null) {
                        return;
                    }
                    textView2.setText("* Max quantity is " + MessBookingDialog.this.getSpinnerAdapter2().getType(position).getMax_qty() + ". Extra quantity, extra charges..!!");
                }
            });
        }
        DialogMessBookingBinding dialogMessBookingBinding5 = get_binding();
        if (dialogMessBookingBinding5 == null || (textView = dialogMessBookingBinding5.bookNowBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MessBookingDialog.setUp$lambda$0(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(MessBookingDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            DialogMessBookingBinding dialogMessBookingBinding = this$0.get_binding();
            Editable text = null;
            int i = Integer.parseInt(String.valueOf((dialogMessBookingBinding == null || (textInputEditText3 = dialogMessBookingBinding.messQuantity) == null) ? null : textInputEditText3.getText()));
            DialogMessBookingBinding dialogMessBookingBinding2 = this$0.get_binding();
            if (!Intrinsics.areEqual(String.valueOf((dialogMessBookingBinding2 == null || (textInputEditText2 = dialogMessBookingBinding2.messQuantity) == null) ? null : textInputEditText2.getText()), "") && !Intrinsics.areEqual(this$0.menu, "")) {
                if (i > this$0.maxQty) {
                    this$0.maxQuantityDialog();
                    return;
                }
                System.out.println((Object) this$0.type);
                System.out.println((Object) this$0.menu);
                System.out.println((Object) "hshshshsh");
                MessBookingViewModel messBookingViewModel = this$0.getMessBookingViewModel();
                String str = this$0.type;
                String str2 = this$0.menu;
                DialogMessBookingBinding dialogMessBookingBinding3 = this$0.get_binding();
                if (dialogMessBookingBinding3 != null && (textInputEditText = dialogMessBookingBinding3.messQuantity) != null) {
                    text = textInputEditText.getText();
                }
                messBookingViewModel.getMessBookingResponse(str, str2, String.valueOf(text));
                return;
            }
            DialogMessBookingBinding dialogMessBookingBinding4 = this$0.get_binding();
            if (dialogMessBookingBinding4 == null || (textView2 = dialogMessBookingBinding4.bookNowBtn) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView2, "Please Fill All Fields!!");
        } catch (NumberFormatException unused) {
            DialogMessBookingBinding dialogMessBookingBinding5 = this$0.get_binding();
            if (dialogMessBookingBinding5 == null || (textView = dialogMessBookingBinding5.maxQtyTv) == null) {
                return;
            }
            ToastExtKt.showErrorToast(textView, "Enter a valid Quantity..!!");
        }
    }

    private final void listenSpinner() {
        getMessBookingViewModel().getMessTypeResponse().observe(getViewLifecycleOwner(), new MessBookingDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends MessTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog.listenSpinner.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$listenSpinner$1$WhenMappings */
            /* JADX INFO: compiled from: MessBookingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends MessTypeResponse> resource) {
                invoke2((Resource<MessTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<MessTypeResponse> resource) {
                TextInputEditText textInputEditText;
                TextInputEditText textInputEditText2;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MessBookingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MessBookingDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MessBookingDialog.this.hideProgress();
                    DialogMessBookingBinding dialogMessBookingBinding = MessBookingDialog.this.get_binding();
                    if (dialogMessBookingBinding == null || (spinner = dialogMessBookingBinding.spinnerMessMenu) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner, message);
                    return;
                }
                MessBookingDialog.this.hideProgress();
                MessTypeResponse data = resource.getData();
                if (data != null) {
                    MessBookingDialog messBookingDialog = MessBookingDialog.this;
                    messBookingDialog.getSpinnerAdapter().addItems(data.getType());
                    System.out.println(data.getType());
                    DialogMessBookingBinding dialogMessBookingBinding2 = messBookingDialog.get_binding();
                    if (dialogMessBookingBinding2 != null && (textInputEditText2 = dialogMessBookingBinding2.etBookingDate) != null) {
                        textInputEditText2.setText(data.getData().get(0).getBooking_date());
                    }
                    DialogMessBookingBinding dialogMessBookingBinding3 = messBookingDialog.get_binding();
                    if (dialogMessBookingBinding3 == null || (textInputEditText = dialogMessBookingBinding3.etBookingDay) == null) {
                        return;
                    }
                    textInputEditText.setText(data.getData().get(0).getDay());
                }
            }
        }));
    }

    private final void listenSpinner2() {
        getMessBookingViewModel().getMessMenuResponse().observe(getViewLifecycleOwner(), new MessBookingDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends MessMenuResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog.listenSpinner2.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$listenSpinner2$1$WhenMappings */
            /* JADX INFO: compiled from: MessBookingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends MessMenuResponse> resource) {
                invoke2((Resource<MessMenuResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<MessMenuResponse> resource) {
                TextView bookNowBtn;
                TextView bookNowBtn2;
                TextView textView;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MessBookingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MessBookingDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MessBookingDialog.this.hideProgress();
                    DialogMessBookingBinding dialogMessBookingBinding = MessBookingDialog.this.get_binding();
                    if (dialogMessBookingBinding == null || (spinner = dialogMessBookingBinding.spinnerMessMenu) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner, message);
                    return;
                }
                MessBookingDialog.this.hideProgress();
                MessMenuResponse data = resource.getData();
                if (data != null) {
                    MessBookingDialog messBookingDialog = MessBookingDialog.this;
                    try {
                        messBookingDialog.getSpinnerAdapter2().addItems(data.getItem());
                        try {
                            messBookingDialog.menu = data.getItem().get(0).getId();
                            messBookingDialog.maxQty = Integer.parseInt(data.getItem().get(0).getMax_qty());
                            DialogMessBookingBinding dialogMessBookingBinding2 = messBookingDialog.get_binding();
                            if (dialogMessBookingBinding2 != null && (textView = dialogMessBookingBinding2.maxQtyTv) != null) {
                                textView.setText("* Max quantity is " + data.getItem().get(0).getMax_qty() + ". Extra quantity, extra charges..!!");
                            }
                            DialogMessBookingBinding dialogMessBookingBinding3 = messBookingDialog.get_binding();
                            TextView textView2 = dialogMessBookingBinding3 != null ? dialogMessBookingBinding3.maxQtyTv : null;
                            if (textView2 != null) {
                                textView2.setVisibility(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                            messBookingDialog.menu = "";
                            DialogMessBookingBinding dialogMessBookingBinding4 = messBookingDialog.get_binding();
                            if (dialogMessBookingBinding4 != null && (bookNowBtn2 = dialogMessBookingBinding4.bookNowBtn) != null) {
                                Intrinsics.checkNotNullExpressionValue(bookNowBtn2, "bookNowBtn");
                                ToastExtKt.showErrorToast(bookNowBtn2, "Item has been Disabled..!!");
                            }
                        }
                        System.out.println(data.getItem());
                        Unit unit = Unit.INSTANCE;
                    } catch (NullPointerException unused2) {
                        DialogMessBookingBinding dialogMessBookingBinding5 = messBookingDialog.get_binding();
                        if (dialogMessBookingBinding5 == null || (bookNowBtn = dialogMessBookingBinding5.bookNowBtn) == null) {
                            return;
                        }
                        Intrinsics.checkNotNullExpressionValue(bookNowBtn, "bookNowBtn");
                        ToastExtKt.showErrorToast(bookNowBtn, "No menus available right now!!");
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            }
        }));
    }

    private final void listenBookResponse() {
        getMessBookingViewModel().getResponse().observe(getViewLifecycleOwner(), new MessBookingDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog.listenBookResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$listenBookResponse$1$WhenMappings */
            /* JADX INFO: compiled from: MessBookingDialog.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<SuccessResponse> resource) {
                TextView bookNowBtn;
                CardView cardView;
                TextView bookNowBtn2;
                TextView bookNowBtn3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        MessBookingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        MessBookingDialog.this.hideProgress();
                        DialogMessBookingBinding dialogMessBookingBinding = MessBookingDialog.this.get_binding();
                        cardView = dialogMessBookingBinding != null ? dialogMessBookingBinding.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    MessBookingDialog.this.hideProgress();
                    DialogMessBookingBinding dialogMessBookingBinding2 = MessBookingDialog.this.get_binding();
                    cardView = dialogMessBookingBinding2 != null ? dialogMessBookingBinding2.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    DialogMessBookingBinding dialogMessBookingBinding3 = MessBookingDialog.this.get_binding();
                    if (dialogMessBookingBinding3 == null || (textView = dialogMessBookingBinding3.bookNowBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                MessBookingDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    MessBookingDialog messBookingDialog = MessBookingDialog.this;
                    if (data.getSuccess()) {
                        try {
                            DialogMessBookingBinding dialogMessBookingBinding4 = messBookingDialog.get_binding();
                            cardView = dialogMessBookingBinding4 != null ? dialogMessBookingBinding4.progressView : null;
                            if (cardView != null) {
                                cardView.setVisibility(8);
                            }
                            DialogMessBookingBinding dialogMessBookingBinding5 = messBookingDialog.get_binding();
                            if (dialogMessBookingBinding5 != null && (bookNowBtn2 = dialogMessBookingBinding5.bookNowBtn) != null) {
                                Intrinsics.checkNotNullExpressionValue(bookNowBtn2, "bookNowBtn");
                                ToastExtKt.showSuccessToast(bookNowBtn2, data.getMessage());
                            }
                            messBookingDialog.dismiss();
                            Unit unit = Unit.INSTANCE;
                            return;
                        } catch (NullPointerException unused) {
                            DialogMessBookingBinding dialogMessBookingBinding6 = messBookingDialog.get_binding();
                            if (dialogMessBookingBinding6 == null || (bookNowBtn = dialogMessBookingBinding6.bookNowBtn) == null) {
                                return;
                            }
                            Intrinsics.checkNotNullExpressionValue(bookNowBtn, "bookNowBtn");
                            ToastExtKt.showInfoToast(bookNowBtn, data.getError());
                            Unit unit2 = Unit.INSTANCE;
                            return;
                        }
                    }
                    DialogMessBookingBinding dialogMessBookingBinding7 = messBookingDialog.get_binding();
                    cardView = dialogMessBookingBinding7 != null ? dialogMessBookingBinding7.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    DialogMessBookingBinding dialogMessBookingBinding8 = messBookingDialog.get_binding();
                    if (dialogMessBookingBinding8 == null || (bookNowBtn3 = dialogMessBookingBinding8.bookNowBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(bookNowBtn3, "bookNowBtn");
                    ToastExtKt.showInfoToast(bookNowBtn3, data.getError());
                }
            }
        }));
    }

    private final void maxQuantityDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.toast_max_qty));
        builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessBookingDialog.maxQuantityDialog$lambda$1(this.f$0, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.hostel.mess.booknow.MessBookingDialog$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessBookingDialog.maxQuantityDialog$lambda$2(dialogInterface, i);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void maxQuantityDialog$lambda$1(MessBookingDialog this$0, DialogInterface dialogInterface, int i) {
        TextInputEditText textInputEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MessBookingViewModel messBookingViewModel = this$0.getMessBookingViewModel();
        String str = this$0.type;
        String str2 = this$0.menu;
        DialogMessBookingBinding dialogMessBookingBinding = this$0.get_binding();
        messBookingViewModel.getMessBookingResponse(str, str2, String.valueOf((dialogMessBookingBinding == null || (textInputEditText = dialogMessBookingBinding.messQuantity) == null) ? null : textInputEditText.getText()));
    }

    public final void setCallBack(MessFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        BookMessListener bookMessListener = this.listener;
        if (bookMessListener != null) {
            bookMessListener.dismiss();
        }
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