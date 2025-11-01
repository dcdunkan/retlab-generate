package in.etuwa.app.ui.internship.apply;

import android.app.DatePickerDialog;
import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.internship.companylist.CompanyListResponse;
import in.etuwa.app.databinding.ApplyInternshipBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.internship.InternshipFragment;
import in.etuwa.app.ui.internship.apply.addcompany.AddCompanyDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.Calendar;
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

/* compiled from: ApplyInternship.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000201B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\u001a\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0006\u0010*\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020\u0019H\u0014J\b\u0010/\u001a\u00020\u0019H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/ui/internship/apply/ApplyInternship;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/internship/apply/addcompany/AddCompanyDialog$AddCompanyListener;", "()V", "_binding", "Lin/etuwa/app/databinding/ApplyInternshipBinding;", "applyInternshipViewModel", "Lin/etuwa/app/ui/internship/apply/ApplyInternshipViewModel;", "getApplyInternshipViewModel", "()Lin/etuwa/app/ui/internship/apply/ApplyInternshipViewModel;", "applyInternshipViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ApplyInternshipBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/internship/apply/ApplyInternship$ApplyInternshipCallBack;", "spinnerAdapter", "Lin/etuwa/app/ui/internship/apply/InternshipCompanySpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/internship/apply/InternshipCompanySpinnerAdapter;", "spinnerAdapter$delegate", "type", "", "dismiss", "", "hideProgress", "listenAddResponse", "listenResponse", "listenSpinner", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "review", "setApplyInternshipCallBack", "context", "Lin/etuwa/app/ui/internship/InternshipFragment;", "setUp", "showProgress", "ApplyInternshipCallBack", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ApplyInternship extends BaseDialog implements AddCompanyDialog.AddCompanyListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ApplyInternshipBinding _binding;

    /* renamed from: applyInternshipViewModel$delegate, reason: from kotlin metadata */
    private final Lazy applyInternshipViewModel;
    private ApplyInternshipCallBack listener;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String type;

    /* compiled from: ApplyInternship.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/internship/apply/ApplyInternship$ApplyInternshipCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ApplyInternshipCallBack {
        void onDismiss();
    }

    @JvmStatic
    public static final ApplyInternship newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ApplyInternship() {
        final ApplyInternship applyInternship = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(applyInternship);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.applyInternshipViewModel = FragmentViewModelLazyKt.createViewModelLazy(applyInternship, Reflection.getOrCreateKotlinClass(ApplyInternshipViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ApplyInternshipViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        final ApplyInternship applyInternship2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(ApplyInternship.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<InternshipCompanySpinnerAdapter>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.internship.apply.InternshipCompanySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InternshipCompanySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = applyInternship2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(InternshipCompanySpinnerAdapter.class), b2, function02);
            }
        });
    }

    private final ApplyInternshipViewModel getApplyInternshipViewModel() {
        return (ApplyInternshipViewModel) this.applyInternshipViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final ApplyInternshipBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InternshipCompanySpinnerAdapter getSpinnerAdapter() {
        return (InternshipCompanySpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: ApplyInternship.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/internship/apply/ApplyInternship$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/internship/apply/ApplyInternship;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ApplyInternship newInstance() {
            return new ApplyInternship();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = ApplyInternshipBinding.inflate(inflater, container, false);
        ApplyInternshipBinding applyInternshipBinding = get_binding();
        if (applyInternshipBinding != null) {
            applyInternshipBinding.setApplyInternshipViewModel(getApplyInternshipViewModel());
        }
        ApplyInternshipBinding applyInternshipBinding2 = get_binding();
        if (applyInternshipBinding2 != null) {
            applyInternshipBinding2.setLifecycleOwner(this);
        }
        ApplyInternshipBinding applyInternshipBinding3 = get_binding();
        if (applyInternshipBinding3 != null) {
            return applyInternshipBinding3.getRoot();
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
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        ApplyInternshipBinding applyInternshipBinding = get_binding();
        Spinner spinner = applyInternshipBinding != null ? applyInternshipBinding.spinnerCompanyNames : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        final int i4 = calendar.get(1);
        final int i5 = calendar.get(2);
        final int i6 = calendar.get(5);
        listenResponse();
        listenSpinner();
        listenAddResponse();
        ApplyInternshipBinding applyInternshipBinding2 = get_binding();
        Spinner spinner2 = applyInternshipBinding2 != null ? applyInternshipBinding2.spinnerCompanyNames : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    InternshipCompanySpinnerAdapter spinnerAdapter;
                    ApplyInternship applyInternship = ApplyInternship.this;
                    spinnerAdapter = applyInternship.getSpinnerAdapter();
                    applyInternship.type = spinnerAdapter.getType(position).getId();
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding3 = get_binding();
        if (applyInternshipBinding3 != null && (textView7 = applyInternshipBinding3.internshipFromDate) != null) {
            textView7.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$1(ApplyInternship.this, i, i2, i3, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding4 = get_binding();
        if (applyInternshipBinding4 != null && (textView6 = applyInternshipBinding4.addCompanyBtn) != null) {
            textView6.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$2(ApplyInternship.this, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding5 = get_binding();
        if (applyInternshipBinding5 != null && (textView5 = applyInternshipBinding5.closeCompanyBtn) != null) {
            textView5.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$3(ApplyInternship.this, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding6 = get_binding();
        if (applyInternshipBinding6 != null && (textView4 = applyInternshipBinding6.addBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$4(ApplyInternship.this, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding7 = get_binding();
        if (applyInternshipBinding7 != null && (textView3 = applyInternshipBinding7.cancelBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$5(ApplyInternship.this, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding8 = get_binding();
        if (applyInternshipBinding8 != null && (textView2 = applyInternshipBinding8.internshipToDate) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ApplyInternship.setUp$lambda$7(ApplyInternship.this, i4, i5, i6, view);
                }
            });
        }
        ApplyInternshipBinding applyInternshipBinding9 = get_binding();
        if (applyInternshipBinding9 == null || (textView = applyInternshipBinding9.applyInternshipBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ApplyInternship.setUp$lambda$8(ApplyInternship.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final ApplyInternship this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda7
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyInternship.setUp$lambda$1$lambda$0(ApplyInternship.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(ApplyInternship this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        TextView textView = applyInternshipBinding != null ? applyInternshipBinding.internshipFromDate : null;
        if (textView == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ApplyInternship this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddCompanyDialog.INSTANCE.newInstance().show(childFragmentManager, (String) null);
        this$0.onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ApplyInternship this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        LinearLayout linearLayout = applyInternshipBinding != null ? applyInternshipBinding.otherCompanyLayout : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        ApplyInternshipBinding applyInternshipBinding2 = this$0.get_binding();
        TextView textView = applyInternshipBinding2 != null ? applyInternshipBinding2.addCompanyBtn : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ApplyInternship this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        Editable editable = null;
        if (Intrinsics.areEqual(String.valueOf((applyInternshipBinding == null || (textInputEditText4 = applyInternshipBinding.etCompanyName) == null) ? null : textInputEditText4.getText()), "")) {
            return;
        }
        ApplyInternshipBinding applyInternshipBinding2 = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((applyInternshipBinding2 == null || (textInputEditText3 = applyInternshipBinding2.etCompanyAddress) == null) ? null : textInputEditText3.getText()), "")) {
            return;
        }
        ApplyInternshipViewModel applyInternshipViewModel = this$0.getApplyInternshipViewModel();
        ApplyInternshipBinding applyInternshipBinding3 = this$0.get_binding();
        String valueOf = String.valueOf((applyInternshipBinding3 == null || (textInputEditText2 = applyInternshipBinding3.etCompanyName) == null) ? null : textInputEditText2.getText());
        ApplyInternshipBinding applyInternshipBinding4 = this$0.get_binding();
        if (applyInternshipBinding4 != null && (textInputEditText = applyInternshipBinding4.etCompanyAddress) != null) {
            editable = textInputEditText.getText();
        }
        applyInternshipViewModel.addCompany(valueOf, String.valueOf(editable));
        this$0.getSpinnerAdapter().notifyDataSetChanged();
        this$0.listenSpinner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ApplyInternship this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        LinearLayout linearLayout = applyInternshipBinding != null ? applyInternshipBinding.applyCompanyLayout : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        ApplyInternshipBinding applyInternshipBinding2 = this$0.get_binding();
        LinearLayout linearLayout2 = applyInternshipBinding2 != null ? applyInternshipBinding2.addCompanyLayout : null;
        if (linearLayout2 == null) {
            return;
        }
        linearLayout2.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(final ApplyInternship this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$$ExternalSyntheticLambda8
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                ApplyInternship.setUp$lambda$7$lambda$6(ApplyInternship.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7$lambda$6(ApplyInternship this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        TextView textView = applyInternshipBinding != null ? applyInternshipBinding.internshipToDate : null;
        if (textView == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$8(ApplyInternship this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ApplyInternshipViewModel applyInternshipViewModel = this$0.getApplyInternshipViewModel();
        String str = this$0.type;
        ApplyInternshipBinding applyInternshipBinding = this$0.get_binding();
        CharSequence charSequence = null;
        String valueOf = String.valueOf((applyInternshipBinding == null || (textView2 = applyInternshipBinding.internshipFromDate) == null) ? null : textView2.getText());
        ApplyInternshipBinding applyInternshipBinding2 = this$0.get_binding();
        if (applyInternshipBinding2 != null && (textView = applyInternshipBinding2.internshipToDate) != null) {
            charSequence = textView.getText();
        }
        applyInternshipViewModel.applyInternship(str, valueOf, String.valueOf(charSequence));
    }

    private final void listenResponse() {
        getApplyInternshipViewModel().getResponse().observe(getViewLifecycleOwner(), new ApplyInternship$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$listenResponse$1

            /* compiled from: ApplyInternship.kt */
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
                ApplyInternshipBinding applyInternshipBinding;
                TextView applyInternshipBtn;
                ApplyInternshipBinding applyInternshipBinding2;
                TextView applyInternshipBtn2;
                ApplyInternshipBinding applyInternshipBinding3;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplyInternship.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplyInternship.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplyInternship.this.hideProgress();
                    applyInternshipBinding3 = ApplyInternship.this.get_binding();
                    if (applyInternshipBinding3 == null || (textView = applyInternshipBinding3.applyInternshipBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplyInternship.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ApplyInternship applyInternship = ApplyInternship.this;
                    if (data.getSuccess()) {
                        applyInternshipBinding2 = applyInternship.get_binding();
                        if (applyInternshipBinding2 != null && (applyInternshipBtn2 = applyInternshipBinding2.applyInternshipBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(applyInternshipBtn2, "applyInternshipBtn");
                            ToastExtKt.showSuccessToast(applyInternshipBtn2, data.getMessage());
                        }
                        applyInternship.dismiss();
                        return;
                    }
                    applyInternshipBinding = applyInternship.get_binding();
                    if (applyInternshipBinding == null || (applyInternshipBtn = applyInternshipBinding.applyInternshipBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(applyInternshipBtn, "applyInternshipBtn");
                    ToastExtKt.showSuccessToast(applyInternshipBtn, data.getError());
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenSpinner() {
        getApplyInternshipViewModel().getListResponse().observe(getViewLifecycleOwner(), new ApplyInternship$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CompanyListResponse>, Unit>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$listenSpinner$1

            /* compiled from: ApplyInternship.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CompanyListResponse> resource) {
                invoke2((Resource<CompanyListResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CompanyListResponse> resource) {
                InternshipCompanySpinnerAdapter spinnerAdapter;
                ApplyInternshipBinding applyInternshipBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ApplyInternship.this.hideProgress();
                    CompanyListResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = ApplyInternship.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getCList());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ApplyInternship.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ApplyInternship.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                ApplyInternship.this.hideProgress();
                applyInternshipBinding = ApplyInternship.this.get_binding();
                if (applyInternshipBinding == null || (spinner = applyInternshipBinding.spinnerCompanyNames) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenAddResponse() {
        getApplyInternshipViewModel().getAddResponse().observe(getViewLifecycleOwner(), new ApplyInternship$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.internship.apply.ApplyInternship$listenAddResponse$1

            /* compiled from: ApplyInternship.kt */
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
                ApplyInternshipBinding applyInternshipBinding;
                TextView addBtn;
                ApplyInternshipBinding applyInternshipBinding2;
                InternshipCompanySpinnerAdapter spinnerAdapter;
                ApplyInternshipBinding applyInternshipBinding3;
                ApplyInternshipBinding applyInternshipBinding4;
                TextView addBtn2;
                ApplyInternshipBinding applyInternshipBinding5;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        ApplyInternship.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        ApplyInternship.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    ApplyInternship.this.hideProgress();
                    applyInternshipBinding5 = ApplyInternship.this.get_binding();
                    if (applyInternshipBinding5 == null || (textView = applyInternshipBinding5.addBtn) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                ApplyInternship.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    ApplyInternship applyInternship = ApplyInternship.this;
                    if (data.getSuccess()) {
                        applyInternshipBinding2 = applyInternship.get_binding();
                        if (applyInternshipBinding2 != null && (addBtn2 = applyInternshipBinding2.addBtn) != null) {
                            Intrinsics.checkNotNullExpressionValue(addBtn2, "addBtn");
                            ToastExtKt.showSuccessToast(addBtn2, data.getMessage());
                        }
                        spinnerAdapter = applyInternship.getSpinnerAdapter();
                        spinnerAdapter.notifyDataSetChanged();
                        applyInternship.listenSpinner();
                        applyInternshipBinding3 = applyInternship.get_binding();
                        LinearLayout linearLayout = applyInternshipBinding3 != null ? applyInternshipBinding3.applyCompanyLayout : null;
                        if (linearLayout != null) {
                            linearLayout.setVisibility(0);
                        }
                        applyInternshipBinding4 = applyInternship.get_binding();
                        LinearLayout linearLayout2 = applyInternshipBinding4 != null ? applyInternshipBinding4.addCompanyLayout : null;
                        if (linearLayout2 == null) {
                            return;
                        }
                        linearLayout2.setVisibility(8);
                        return;
                    }
                    applyInternshipBinding = applyInternship.get_binding();
                    if (applyInternshipBinding == null || (addBtn = applyInternshipBinding.addBtn) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(addBtn, "addBtn");
                    ToastExtKt.showSuccessToast(addBtn, data.getError());
                }
            }
        }));
    }

    public final void review() {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        AddCompanyDialog newInstance = AddCompanyDialog.INSTANCE.newInstance();
        newInstance.setCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    public final void setApplyInternshipCallBack(InternshipFragment context) {
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

    @Override // androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
    }
}