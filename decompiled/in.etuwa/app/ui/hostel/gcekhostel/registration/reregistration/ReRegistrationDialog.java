package in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration;

import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
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
import androidx.exifinterface.media.ExifInterface;
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
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.newregistration.CategoryTypeResponse;
import in.etuwa.app.data.model.hostel.gcekhostel.reregistration.PresentHostelResponse;
import in.etuwa.app.databinding.DialogReRegistrationBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogKt;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.hostel.gcekhostel.registration.RegistrationFragment;
import in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: ReRegistrationDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ReRegistrationDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogReRegistrationBinding _binding;
    private String behaviour;
    private String category;
    private String defaulters;
    private ReRegistrationListener listener;
    private String noOfYears;
    private File pickFile;
    private int pos;
    private String presentHostel;

    /* JADX INFO: renamed from: reRegistrationViewModel$delegate, reason: from kotlin metadata */
    private final Lazy reRegistrationViewModel;
    private String semester;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;

    /* JADX INFO: renamed from: spinnerAdapter3$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter3;

    /* JADX INFO: renamed from: spinnerAdapter4$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter4;

    /* JADX INFO: renamed from: spinnerAdapter5$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter5;

    /* JADX INFO: renamed from: spinnerAdapter6$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter6;

    /* JADX INFO: compiled from: ReRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/ReRegistrationDialog$ReRegistrationListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface ReRegistrationListener {
        void dismiss();
    }

    /* JADX INFO: compiled from: ReRegistrationDialog.kt */
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
    public static final ReRegistrationDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public ReRegistrationDialog() {
        final ReRegistrationDialog reRegistrationDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return reRegistrationDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(reRegistrationDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.reRegistrationViewModel = FragmentViewModelLazyKt.createViewModelLazy(reRegistrationDialog, Reflection.getOrCreateKotlinClass(ReRegistrationViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ReRegistrationViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.category = "";
        this.semester = "";
        this.presentHostel = "";
        this.noOfYears = "";
        this.behaviour = "";
        this.defaulters = "";
        this.pos = 1;
        final ReRegistrationDialog reRegistrationDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter$2
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
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CategorySpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.newregistration.CategorySpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CategorySpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CategorySpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter2$2
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
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter3$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<PresentHostelSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.PresentHostelSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final PresentHostelSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(PresentHostelSpinnerAdapter.class), b4, function04);
            }
        });
        final Function0<ParametersHolder> function05 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter4$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode4 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        this.spinnerAdapter4 = LazyKt.lazy(lazyThreadSafetyMode4, (Function0) new Function0<DefaulterSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.DefaulterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final DefaulterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(DefaulterSpinnerAdapter.class), b5, function05);
            }
        });
        final Function0<ParametersHolder> function06 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter5$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode5 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        this.spinnerAdapter5 = LazyKt.lazy(lazyThreadSafetyMode5, (Function0) new Function0<FineSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.FineSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final FineSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(FineSpinnerAdapter.class), b6, function06);
            }
        });
        final Function0<ParametersHolder> function07 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$spinnerAdapter6$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(this.this$0.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode6 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b7 = 0 == true ? 1 : 0;
        this.spinnerAdapter6 = LazyKt.lazy(lazyThreadSafetyMode6, (Function0) new Function0<NoOfYearSpinnerAdapter>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.NoOfYearSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final NoOfYearSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = reRegistrationDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(NoOfYearSpinnerAdapter.class), b7, function07);
            }
        });
    }

    private final ReRegistrationViewModel getReRegistrationViewModel() {
        return (ReRegistrationViewModel) this.reRegistrationViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogReRegistrationBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CategorySpinnerAdapter getSpinnerAdapter() {
        return (CategorySpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter2() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PresentHostelSpinnerAdapter getSpinnerAdapter3() {
        return (PresentHostelSpinnerAdapter) this.spinnerAdapter3.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DefaulterSpinnerAdapter getSpinnerAdapter4() {
        return (DefaulterSpinnerAdapter) this.spinnerAdapter4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FineSpinnerAdapter getSpinnerAdapter5() {
        return (FineSpinnerAdapter) this.spinnerAdapter5.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NoOfYearSpinnerAdapter getSpinnerAdapter6() {
        return (NoOfYearSpinnerAdapter) this.spinnerAdapter6.getValue();
    }

    /* JADX INFO: compiled from: ReRegistrationDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/ReRegistrationDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/hostel/gcekhostel/registration/reregistration/ReRegistrationDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ReRegistrationDialog newInstance() {
            ReRegistrationDialog reRegistrationDialog = new ReRegistrationDialog();
            reRegistrationDialog.setArguments(new Bundle());
            return reRegistrationDialog;
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
        this._binding = DialogReRegistrationBinding.inflate(inflater, container, false);
        DialogReRegistrationBinding dialogReRegistrationBinding = get_binding();
        if (dialogReRegistrationBinding != null) {
            dialogReRegistrationBinding.setReRegistrationViewModel(getReRegistrationViewModel());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding2 = get_binding();
        if (dialogReRegistrationBinding2 != null) {
            dialogReRegistrationBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding3 = get_binding();
        if (dialogReRegistrationBinding3 != null) {
            return dialogReRegistrationBinding3.getRoot();
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
        DialogReRegistrationBinding dialogReRegistrationBinding = get_binding();
        Spinner spinner = dialogReRegistrationBinding != null ? dialogReRegistrationBinding.spinnerCatogory : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding2 = get_binding();
        Spinner spinner2 = dialogReRegistrationBinding2 != null ? dialogReRegistrationBinding2.spinnerSemesterApplied : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding3 = get_binding();
        Spinner spinner3 = dialogReRegistrationBinding3 != null ? dialogReRegistrationBinding3.spinnerPresentHostel : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapter3());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding4 = get_binding();
        Spinner spinner4 = dialogReRegistrationBinding4 != null ? dialogReRegistrationBinding4.spinnerNoOfYear : null;
        if (spinner4 != null) {
            spinner4.setAdapter((SpinnerAdapter) getSpinnerAdapter6());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding5 = get_binding();
        Spinner spinner5 = dialogReRegistrationBinding5 != null ? dialogReRegistrationBinding5.spinnerBehaviour : null;
        if (spinner5 != null) {
            spinner5.setAdapter((SpinnerAdapter) getSpinnerAdapter5());
        }
        DialogReRegistrationBinding dialogReRegistrationBinding6 = get_binding();
        Spinner spinner6 = dialogReRegistrationBinding6 != null ? dialogReRegistrationBinding6.spinnerDefaulter : null;
        if (spinner6 != null) {
            spinner6.setAdapter((SpinnerAdapter) getSpinnerAdapter4());
        }
        DefaulterSpinnerAdapter spinnerAdapter4 = getSpinnerAdapter4();
        if (spinnerAdapter4 != null) {
            spinnerAdapter4.addItems(new String[]{"No", "Yes"});
        }
        FineSpinnerAdapter spinnerAdapter5 = getSpinnerAdapter5();
        if (spinnerAdapter5 != null) {
            spinnerAdapter5.addItems(new String[]{"No", "Yes"});
        }
        NoOfYearSpinnerAdapter spinnerAdapter6 = getSpinnerAdapter6();
        if (spinnerAdapter6 != null) {
            spinnerAdapter6.addItems(new String[]{"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6"});
        }
        listenSpinnerResponse();
        listenSemResponse();
        listenResponse();
        listenProgressResponse();
        listenPresentSpinnerResponse();
        DialogReRegistrationBinding dialogReRegistrationBinding7 = get_binding();
        Spinner spinner7 = dialogReRegistrationBinding7 != null ? dialogReRegistrationBinding7.spinnerCatogory : null;
        if (spinner7 != null) {
            spinner7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.category = String.valueOf(reRegistrationDialog.getSpinnerAdapter().getType(position).getId());
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding8 = get_binding();
        Spinner spinner8 = dialogReRegistrationBinding8 != null ? dialogReRegistrationBinding8.spinnerSemesterApplied : null;
        if (spinner8 != null) {
            spinner8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.semester = reRegistrationDialog.getSpinnerAdapter2().getSemester(position).getId();
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding9 = get_binding();
        Spinner spinner9 = dialogReRegistrationBinding9 != null ? dialogReRegistrationBinding9.spinnerPresentHostel : null;
        if (spinner9 != null) {
            spinner9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.presentHostel = String.valueOf(reRegistrationDialog.getSpinnerAdapter3().getType(position).getId());
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding10 = get_binding();
        Spinner spinner10 = dialogReRegistrationBinding10 != null ? dialogReRegistrationBinding10.spinnerDefaulter : null;
        if (spinner10 != null) {
            spinner10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.defaulters = reRegistrationDialog.getSpinnerAdapter4().getSemester(position);
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding11 = get_binding();
        Spinner spinner11 = dialogReRegistrationBinding11 != null ? dialogReRegistrationBinding11.spinnerBehaviour : null;
        if (spinner11 != null) {
            spinner11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.5
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.behaviour = reRegistrationDialog.getSpinnerAdapter5().getSemester(position);
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding12 = get_binding();
        Spinner spinner12 = dialogReRegistrationBinding12 != null ? dialogReRegistrationBinding12.spinnerNoOfYear : null;
        if (spinner12 != null) {
            spinner12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.setUp.6
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    ReRegistrationDialog reRegistrationDialog = ReRegistrationDialog.this;
                    reRegistrationDialog.noOfYears = reRegistrationDialog.getSpinnerAdapter6().getSemester(position);
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding13 = get_binding();
        if (dialogReRegistrationBinding13 != null && (textView2 = dialogReRegistrationBinding13.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReRegistrationDialog.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        DialogReRegistrationBinding dialogReRegistrationBinding14 = get_binding();
        if (dialogReRegistrationBinding14 == null || (textView = dialogReRegistrationBinding14.registerBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReRegistrationDialog.setUp$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ReRegistrationDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ReRegistrationDialog this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        File file;
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextView textView4;
        TextInputEditText textInputEditText8;
        TextView textView5;
        TextInputEditText textInputEditText9;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            File file2 = this$0.pickFile;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file2 = null;
            }
            if (file2.exists()) {
                File file3 = this$0.pickFile;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file3 = null;
                }
                if (file3.length() / ((long) 1024) <= 500) {
                    this$0.setCancelable(false);
                    DialogReRegistrationBinding dialogReRegistrationBinding = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogReRegistrationBinding == null || (textInputEditText9 = dialogReRegistrationBinding.etAnnualIncome) == null) ? null : textInputEditText9.getText()), "")) {
                        DialogReRegistrationBinding dialogReRegistrationBinding2 = this$0.get_binding();
                        if (dialogReRegistrationBinding2 == null || (textView5 = dialogReRegistrationBinding2.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView5, "Annual Income Cannot be empty");
                        return;
                    }
                    DialogReRegistrationBinding dialogReRegistrationBinding3 = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((dialogReRegistrationBinding3 == null || (textInputEditText8 = dialogReRegistrationBinding3.etDistance) == null) ? null : textInputEditText8.getText()), "")) {
                        DialogReRegistrationBinding dialogReRegistrationBinding4 = this$0.get_binding();
                        if (dialogReRegistrationBinding4 == null || (textView4 = dialogReRegistrationBinding4.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView4, "Distance cannot be empty");
                        return;
                    }
                    ReRegistrationViewModel reRegistrationViewModel = this$0.getReRegistrationViewModel();
                    String str = this$0.category;
                    DialogReRegistrationBinding dialogReRegistrationBinding5 = this$0.get_binding();
                    String strValueOf = String.valueOf((dialogReRegistrationBinding5 == null || (textInputEditText7 = dialogReRegistrationBinding5.etNameAddress) == null) ? null : textInputEditText7.getText());
                    DialogReRegistrationBinding dialogReRegistrationBinding6 = this$0.get_binding();
                    String strValueOf2 = String.valueOf((dialogReRegistrationBinding6 == null || (textInputEditText6 = dialogReRegistrationBinding6.etPhone) == null) ? null : textInputEditText6.getText());
                    DialogReRegistrationBinding dialogReRegistrationBinding7 = this$0.get_binding();
                    String strValueOf3 = String.valueOf((dialogReRegistrationBinding7 == null || (textInputEditText5 = dialogReRegistrationBinding7.etAnnualIncome) == null) ? null : textInputEditText5.getText());
                    DialogReRegistrationBinding dialogReRegistrationBinding8 = this$0.get_binding();
                    String strValueOf4 = String.valueOf((dialogReRegistrationBinding8 == null || (textInputEditText4 = dialogReRegistrationBinding8.etDistance) == null) ? null : textInputEditText4.getText());
                    String str2 = this$0.semester;
                    File file4 = this$0.pickFile;
                    if (file4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                        file = null;
                    } else {
                        file = file4;
                    }
                    String str3 = this$0.presentHostel;
                    String str4 = this$0.noOfYears;
                    DialogReRegistrationBinding dialogReRegistrationBinding9 = this$0.get_binding();
                    String strValueOf5 = String.valueOf((dialogReRegistrationBinding9 == null || (textInputEditText3 = dialogReRegistrationBinding9.etHostelDetails) == null) ? null : textInputEditText3.getText());
                    String str5 = this$0.behaviour;
                    String str6 = this$0.defaulters;
                    DialogReRegistrationBinding dialogReRegistrationBinding10 = this$0.get_binding();
                    String strValueOf6 = String.valueOf((dialogReRegistrationBinding10 == null || (textInputEditText2 = dialogReRegistrationBinding10.etFineDetails) == null) ? null : textInputEditText2.getText());
                    DialogReRegistrationBinding dialogReRegistrationBinding11 = this$0.get_binding();
                    reRegistrationViewModel.newRegistration("", str, strValueOf, strValueOf2, strValueOf3, strValueOf4, str2, file, str3, str4, strValueOf5, str5, str6, strValueOf6, String.valueOf((dialogReRegistrationBinding11 == null || (textInputEditText = dialogReRegistrationBinding11.etDueDetails) == null) ? null : textInputEditText.getText()));
                    DialogReRegistrationBinding dialogReRegistrationBinding12 = this$0.get_binding();
                    LinearLayout linearLayout = dialogReRegistrationBinding12 != null ? dialogReRegistrationBinding12.completionCard : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                    DialogReRegistrationBinding dialogReRegistrationBinding13 = this$0.get_binding();
                    CardView cardView = dialogReRegistrationBinding13 != null ? dialogReRegistrationBinding13.progressView : null;
                    if (cardView == null) {
                        return;
                    }
                    cardView.setVisibility(0);
                    return;
                }
                DialogReRegistrationBinding dialogReRegistrationBinding14 = this$0.get_binding();
                if (dialogReRegistrationBinding14 == null || (textView3 = dialogReRegistrationBinding14.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 500KB");
                return;
            }
            DialogReRegistrationBinding dialogReRegistrationBinding15 = this$0.get_binding();
            if (dialogReRegistrationBinding15 == null || (textView2 = dialogReRegistrationBinding15.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            DialogReRegistrationBinding dialogReRegistrationBinding16 = this$0.get_binding();
            if (dialogReRegistrationBinding16 == null || (textView = dialogReRegistrationBinding16.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Something went wrong.");
        }
    }

    private final void listenSpinnerResponse() {
        getReRegistrationViewModel().getResponse().observe(getViewLifecycleOwner(), new ReRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CategoryTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.listenSpinnerResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$listenSpinnerResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ReRegistrationDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CategoryTypeResponse> resource) {
                invoke2((Resource<CategoryTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CategoryTypeResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ReRegistrationDialog.this.hideProgress();
                    CategoryTypeResponse data = resource.getData();
                    if (data != null) {
                        try {
                            ReRegistrationDialog.this.getSpinnerAdapter().addItems(data.getCategory());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    ReRegistrationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ReRegistrationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                ReRegistrationDialog.this.hideProgress();
                DialogReRegistrationBinding dialogReRegistrationBinding = ReRegistrationDialog.this.get_binding();
                if (dialogReRegistrationBinding == null || (spinner = dialogReRegistrationBinding.spinnerCatogory) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenPresentSpinnerResponse() {
        getReRegistrationViewModel().getPresentHostelResponse().observe(getViewLifecycleOwner(), new ReRegistrationDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends PresentHostelResponse>, Unit>() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog.listenPresentSpinnerResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$listenPresentSpinnerResponse$1$WhenMappings */
            /* JADX INFO: compiled from: ReRegistrationDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends PresentHostelResponse> resource) {
                invoke2((Resource<PresentHostelResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<PresentHostelResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ReRegistrationDialog.this.hideProgress();
                    PresentHostelResponse data = resource.getData();
                    if (data != null) {
                        try {
                            ReRegistrationDialog.this.getSpinnerAdapter3().addItems(data.getHostel());
                            return;
                        } catch (NullPointerException unused) {
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    ReRegistrationDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ReRegistrationDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                ReRegistrationDialog.this.hideProgress();
                DialogReRegistrationBinding dialogReRegistrationBinding = ReRegistrationDialog.this.get_binding();
                if (dialogReRegistrationBinding == null || (spinner = dialogReRegistrationBinding.spinnerCatogory) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSemResponse() {
        getReRegistrationViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReRegistrationDialog.listenSemResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$5(ReRegistrationDialog this$0, Resource resource) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Semester> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.getSpinnerAdapter2().addItems(arrayList);
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
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        DialogReRegistrationBinding dialogReRegistrationBinding = this$0.get_binding();
        if (dialogReRegistrationBinding == null || (spinner = dialogReRegistrationBinding.spinnerSemesterApplied) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(spinner, message);
    }

    private final void listenResponse() {
        getReRegistrationViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReRegistrationDialog.listenResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$7(ReRegistrationDialog this$0, Resource resource) {
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
            DialogReRegistrationBinding dialogReRegistrationBinding = this$0.get_binding();
            if (dialogReRegistrationBinding != null && (textView = dialogReRegistrationBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            ReRegistrationListener reRegistrationListener = this$0.listener;
            if (reRegistrationListener != null) {
                reRegistrationListener.dismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getLogin()) {
                DialogReRegistrationBinding dialogReRegistrationBinding2 = this$0.get_binding();
                if (dialogReRegistrationBinding2 != null && (completionFileName2 = dialogReRegistrationBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                ReRegistrationListener reRegistrationListener2 = this$0.listener;
                if (reRegistrationListener2 != null) {
                    reRegistrationListener2.dismiss();
                }
                this$0.dismiss();
                return;
            }
            DialogReRegistrationBinding dialogReRegistrationBinding3 = this$0.get_binding();
            if (dialogReRegistrationBinding3 != null && (completionFileName = dialogReRegistrationBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, "Something went wrong");
            }
            ReRegistrationListener reRegistrationListener3 = this$0.listener;
            if (reRegistrationListener3 != null) {
                reRegistrationListener3.dismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getReRegistrationViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.gcekhostel.registration.reregistration.ReRegistrationDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReRegistrationDialog.listenProgressResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$9(ReRegistrationDialog this$0, Resource resource) {
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
            DialogReRegistrationBinding dialogReRegistrationBinding = this$0.get_binding();
            if (dialogReRegistrationBinding == null || (textView = dialogReRegistrationBinding.completionFileName) == null) {
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
            float fFloatValue = f.floatValue();
            DialogReRegistrationBinding dialogReRegistrationBinding2 = this$0.get_binding();
            ProgressBar progressBar = dialogReRegistrationBinding2 != null ? dialogReRegistrationBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) fFloatValue);
            }
            DialogReRegistrationBinding dialogReRegistrationBinding3 = this$0.get_binding();
            TextView textView2 = dialogReRegistrationBinding3 != null ? dialogReRegistrationBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) fFloatValue) + " %");
            }
            if (((int) fFloatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        String fileName;
        ContentResolver contentResolver2;
        String fileName2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                DialogReRegistrationBinding dialogReRegistrationBinding = get_binding();
                TextView textView = dialogReRegistrationBinding != null ? dialogReRegistrationBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        fileName2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        fileName2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + fileName2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(parcelFileDescriptorOpenFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        fileName = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        fileName = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, fileName);
                    ByteStreamsKt.copyTo$default(new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setCallBack(RegistrationFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        ReRegistrationListener reRegistrationListener = this.listener;
        if (reRegistrationListener != null) {
            reRegistrationListener.dismiss();
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