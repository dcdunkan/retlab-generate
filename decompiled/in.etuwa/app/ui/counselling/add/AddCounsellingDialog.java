package in.etuwa.app.ui.counselling.add;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.counselling.status.CounsellingStatus;
import in.etuwa.app.data.model.counselling.status.CounsellingStatusResponse;
import in.etuwa.app.data.model.counselling.type.CounsellingTypes;
import in.etuwa.app.data.model.counselling.type.CounsellingTypesResponse;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.databinding.AddCounsellingDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.counselling.CounsellingFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.HashMap;
import java.util.Iterator;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: AddCounsellingDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AddCounsellingDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddCounsellingDialogBinding _binding;

    /* JADX INFO: renamed from: addCounsellingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addCounsellingViewModel;
    private String after;
    private String before;
    private ViewCounsellingResponse editResponse;
    private String id;
    private boolean isReOpen;
    private AddCounsellingListener listener;

    /* JADX INFO: renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* JADX INFO: renamed from: spinnerAdapter2$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter2;

    /* JADX INFO: renamed from: spinnerAdapter3$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter3;
    private String type;

    /* JADX INFO: compiled from: AddCounsellingDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$AddCounsellingListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddCounsellingListener {
        void dismiss();
    }

    @JvmStatic
    public static final AddCounsellingDialog newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddCounsellingDialog() {
        final AddCounsellingDialog addCounsellingDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return addCounsellingDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addCounsellingDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addCounsellingViewModel = FragmentViewModelLazyKt.createViewModelLazy(addCounsellingDialog, Reflection.getOrCreateKotlinClass(AddCounsellingViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(AddCounsellingViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        this.before = "";
        this.after = "";
        final AddCounsellingDialog addCounsellingDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter$2
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
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CounsellingTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingTypeSpinnerAdapter.class), b2, function02);
            }
        });
        final Function0<ParametersHolder> function03 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter2$2
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
        this.spinnerAdapter2 = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b3, function03);
            }
        });
        final Function0<ParametersHolder> function04 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$spinnerAdapter3$2
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
        this.spinnerAdapter3 = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<CounsellingStatusSpinnerAdapter>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.counselling.add.CounsellingStatusSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CounsellingStatusSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addCounsellingDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CounsellingStatusSpinnerAdapter.class), b4, function04);
            }
        });
    }

    private final AddCounsellingViewModel getAddCounsellingViewModel() {
        return (AddCounsellingViewModel) this.addCounsellingViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final AddCounsellingDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingTypeSpinnerAdapter getSpinnerAdapter() {
        return (CounsellingTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingStatusSpinnerAdapter getSpinnerAdapter2() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerAdapter2.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CounsellingStatusSpinnerAdapter getSpinnerAdapter3() {
        return (CounsellingStatusSpinnerAdapter) this.spinnerAdapter3.getValue();
    }

    /* JADX INFO: compiled from: AddCounsellingDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/add/AddCounsellingDialog;", "id", "", "isReOpen", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddCounsellingDialog newInstance(String id, boolean isReOpen) {
            AddCounsellingDialog addCounsellingDialog = new AddCounsellingDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("reopen", isReOpen);
            addCounsellingDialog.setArguments(bundle);
            return addCounsellingDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
            this.isReOpen = arguments.getBoolean("reopen");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AddCounsellingDialogBinding.inflate(inflater, container, false);
        AddCounsellingDialogBinding addCounsellingDialogBinding = get_binding();
        if (addCounsellingDialogBinding != null) {
            addCounsellingDialogBinding.setAddCounsellingDialogViewModel(getAddCounsellingViewModel());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = get_binding();
        if (addCounsellingDialogBinding2 != null) {
            addCounsellingDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = get_binding();
        if (addCounsellingDialogBinding3 != null) {
            return addCounsellingDialogBinding3.getRoot();
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
        MaterialButton materialButton;
        AddCounsellingDialogBinding addCounsellingDialogBinding = get_binding();
        Spinner spinner = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.spinnerCouncellingType : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = get_binding();
        Spinner spinner2 = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.spinnerCouncellingBefore : null;
        if (spinner2 != null) {
            spinner2.setAdapter((SpinnerAdapter) getSpinnerAdapter2());
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = get_binding();
        Spinner spinner3 = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.spinnerCouncellingMeet : null;
        if (spinner3 != null) {
            spinner3.setAdapter((SpinnerAdapter) getSpinnerAdapter3());
        }
        listenSpinner();
        listenSpinner2();
        listenSpinner3();
        listenAddResponse();
        listenViewCounselling();
        listenProgressResponse();
        listenReopenResponse();
        if (this.id != null) {
            getAddCounsellingViewModel().viewGrievance(this.id);
            AddCounsellingDialogBinding addCounsellingDialogBinding4 = get_binding();
            TextView textView = addCounsellingDialogBinding4 != null ? addCounsellingDialogBinding4.councTitle : null;
            if (textView != null) {
                textView.setText("Edit Counselling");
            }
            AddCounsellingDialogBinding addCounsellingDialogBinding5 = get_binding();
            MaterialButton materialButton2 = addCounsellingDialogBinding5 != null ? addCounsellingDialogBinding5.addCounsellingBtn : null;
            if (materialButton2 != null) {
                materialButton2.setText("Update Counselling");
            }
        }
        if (this.isReOpen) {
            AddCounsellingDialogBinding addCounsellingDialogBinding6 = get_binding();
            TextInputLayout textInputLayout = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.comntLayout : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
            getAddCounsellingViewModel().viewGrievance(this.id);
            AddCounsellingDialogBinding addCounsellingDialogBinding7 = get_binding();
            TextView textView2 = addCounsellingDialogBinding7 != null ? addCounsellingDialogBinding7.councTitle : null;
            if (textView2 != null) {
                textView2.setText("Reopen Counselling");
            }
            AddCounsellingDialogBinding addCounsellingDialogBinding8 = get_binding();
            MaterialButton materialButton3 = addCounsellingDialogBinding8 != null ? addCounsellingDialogBinding8.addCounsellingBtn : null;
            if (materialButton3 != null) {
                materialButton3.setText("Repost Counselling");
            }
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding9 = get_binding();
        Spinner spinner4 = addCounsellingDialogBinding9 != null ? addCounsellingDialogBinding9.spinnerCouncellingType : null;
        if (spinner4 != null) {
            spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.setUp.1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    addCounsellingDialog.type = addCounsellingDialog.getSpinnerAdapter().getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding10 = get_binding();
        Spinner spinner5 = addCounsellingDialogBinding10 != null ? addCounsellingDialogBinding10.spinnerCouncellingBefore : null;
        if (spinner5 != null) {
            spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.setUp.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    addCounsellingDialog.before = addCounsellingDialog.getSpinnerAdapter2().getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding11 = get_binding();
        Spinner spinner6 = addCounsellingDialogBinding11 != null ? addCounsellingDialogBinding11.spinnerCouncellingMeet : null;
        if (spinner6 != null) {
            spinner6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.setUp.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    addCounsellingDialog.after = addCounsellingDialog.getSpinnerAdapter3().getType(position).getId();
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding12 = get_binding();
        if (addCounsellingDialogBinding12 == null || (materialButton = addCounsellingDialogBinding12.addCounsellingBtn) == null) {
            return;
        }
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddCounsellingDialog.setUp$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AddCounsellingDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        TextInputEditText textInputEditText4;
        TextInputEditText textInputEditText5;
        TextInputEditText textInputEditText6;
        TextInputEditText textInputEditText7;
        TextInputEditText textInputEditText8;
        TextInputEditText textInputEditText9;
        TextInputEditText textInputEditText10;
        TextInputEditText textInputEditText11;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, RequestBody> map = new HashMap<>();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType mediaType = MultipartBody.FORM;
        String str = this$0.id;
        if (str == null) {
            str = "";
        }
        RequestBody requestBodyCreate = companion.create(mediaType, str);
        HashMap<String, RequestBody> map2 = map;
        map2.put("CounsellingRequests[counselling_type]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.type));
        RequestBody.Companion companion2 = RequestBody.INSTANCE;
        MediaType mediaType2 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding = this$0.get_binding();
        Editable text = null;
        map2.put("CounsellingRequests[concern]", companion2.create(mediaType2, String.valueOf((addCounsellingDialogBinding == null || (textInputEditText11 = addCounsellingDialogBinding.etCsConcern) == null) ? null : textInputEditText11.getText())));
        RequestBody.Companion companion3 = RequestBody.INSTANCE;
        MediaType mediaType3 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = this$0.get_binding();
        map2.put("CounsellingRequests[impact_home]", companion3.create(mediaType3, String.valueOf((addCounsellingDialogBinding2 == null || (textInputEditText10 = addCounsellingDialogBinding2.etCsConcernHome) == null) ? null : textInputEditText10.getText())));
        RequestBody.Companion companion4 = RequestBody.INSTANCE;
        MediaType mediaType4 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = this$0.get_binding();
        map2.put("CounsellingRequests[impact_studies]", companion4.create(mediaType4, String.valueOf((addCounsellingDialogBinding3 == null || (textInputEditText9 = addCounsellingDialogBinding3.csConcernStudies) == null) ? null : textInputEditText9.getText())));
        RequestBody.Companion companion5 = RequestBody.INSTANCE;
        MediaType mediaType5 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding4 = this$0.get_binding();
        map2.put("CounsellingRequests[impact_relationship]", companion5.create(mediaType5, String.valueOf((addCounsellingDialogBinding4 == null || (textInputEditText8 = addCounsellingDialogBinding4.csRelationship) == null) ? null : textInputEditText8.getText())));
        RequestBody.Companion companion6 = RequestBody.INSTANCE;
        MediaType mediaType6 = MultipartBody.FORM;
        AddCounsellingDialogBinding addCounsellingDialogBinding5 = this$0.get_binding();
        map2.put("CounsellingRequests[impact_physically_emotionally]", companion6.create(mediaType6, String.valueOf((addCounsellingDialogBinding5 == null || (textInputEditText7 = addCounsellingDialogBinding5.csPhisical) == null) ? null : textInputEditText7.getText())));
        map2.put("CounsellingRequests[counselling_session_required]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.after));
        map2.put("CounsellingRequests[counselling_history]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.before));
        String str2 = this$0.id;
        if (str2 == null || str2.length() == 0) {
            this$0.getAddCounsellingViewModel().addCouselling(map);
            return;
        }
        if (this$0.isReOpen) {
            AddCounsellingViewModel addCounsellingViewModel = this$0.getAddCounsellingViewModel();
            String str3 = this$0.id;
            String str4 = this$0.type;
            AddCounsellingDialogBinding addCounsellingDialogBinding6 = this$0.get_binding();
            String strValueOf = String.valueOf((addCounsellingDialogBinding6 == null || (textInputEditText6 = addCounsellingDialogBinding6.etCsConcern) == null) ? null : textInputEditText6.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding7 = this$0.get_binding();
            String strValueOf2 = String.valueOf((addCounsellingDialogBinding7 == null || (textInputEditText5 = addCounsellingDialogBinding7.etCsConcernHome) == null) ? null : textInputEditText5.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding8 = this$0.get_binding();
            String strValueOf3 = String.valueOf((addCounsellingDialogBinding8 == null || (textInputEditText4 = addCounsellingDialogBinding8.csConcernStudies) == null) ? null : textInputEditText4.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding9 = this$0.get_binding();
            String strValueOf4 = String.valueOf((addCounsellingDialogBinding9 == null || (textInputEditText3 = addCounsellingDialogBinding9.csRelationship) == null) ? null : textInputEditText3.getText());
            AddCounsellingDialogBinding addCounsellingDialogBinding10 = this$0.get_binding();
            String strValueOf5 = String.valueOf((addCounsellingDialogBinding10 == null || (textInputEditText2 = addCounsellingDialogBinding10.csPhisical) == null) ? null : textInputEditText2.getText());
            String str5 = this$0.before;
            String str6 = this$0.after;
            AddCounsellingDialogBinding addCounsellingDialogBinding11 = this$0.get_binding();
            if (addCounsellingDialogBinding11 != null && (textInputEditText = addCounsellingDialogBinding11.csComment) != null) {
                text = textInputEditText.getText();
            }
            addCounsellingViewModel.reopenCounselling(str3, str4, strValueOf, strValueOf2, strValueOf3, strValueOf4, strValueOf5, str5, str6, String.valueOf(text));
            return;
        }
        this$0.getAddCounsellingViewModel().updateCounselling(requestBodyCreate, map);
    }

    private final void listenSpinner() {
        getAddCounsellingViewModel().getTypeResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingTypesResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenSpinner.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingTypesResponse> resource) {
                invoke2((Resource<CounsellingTypesResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingTypesResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingTypesResponse data = resource.getData();
                    if (data != null) {
                        AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                        addCounsellingDialog.getSpinnerAdapter().addItems(data.getCTypes());
                        addCounsellingDialog.applySpinnerSelectionIfReady();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSpinner2() {
        getAddCounsellingViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingStatusResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenSpinner2.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner2$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingStatusResponse> resource) {
                invoke2((Resource<CounsellingStatusResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingStatusResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingStatusResponse data = resource.getData();
                    if (data != null) {
                        AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                        addCounsellingDialog.getSpinnerAdapter2().addItems(data.getData());
                        addCounsellingDialog.applySpinnerSelectionIfReady();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenSpinner3() {
        getAddCounsellingViewModel().getStatusResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends CounsellingStatusResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenSpinner3.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenSpinner3$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends CounsellingStatusResponse> resource) {
                invoke2((Resource<CounsellingStatusResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<CounsellingStatusResponse> resource) {
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddCounsellingDialog.this.hideProgress();
                    CounsellingStatusResponse data = resource.getData();
                    if (data != null) {
                        AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                        addCounsellingDialog.getSpinnerAdapter3().addItems(data.getData());
                        addCounsellingDialog.applySpinnerSelectionIfReady();
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddCounsellingDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddCounsellingDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenViewCounselling() {
        getAddCounsellingViewModel().getViewResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewCounsellingResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenViewCounselling.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenViewCounselling$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewCounsellingResponse> resource) {
                invoke2((Resource<ViewCounsellingResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewCounsellingResponse> resource) {
                TextInputEditText textInputEditText;
                TextInputEditText textInputEditText2;
                TextInputEditText textInputEditText3;
                TextInputEditText textInputEditText4;
                TextInputEditText textInputEditText5;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding == null || (spinner = addCounsellingDialogBinding.spinnerCouncellingType) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(spinner, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                ViewCounsellingResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    AddCounsellingDialogBinding addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding2 != null && (textInputEditText5 = addCounsellingDialogBinding2.etCsConcern) != null) {
                        textInputEditText5.setText(data.getRequests().getConcern());
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding3 != null && (textInputEditText4 = addCounsellingDialogBinding3.etCsConcernHome) != null) {
                        textInputEditText4.setText(data.getRequests().getImpactHome());
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding4 != null && (textInputEditText3 = addCounsellingDialogBinding4.csConcernStudies) != null) {
                        textInputEditText3.setText(data.getRequests().getImpactStudies());
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding5 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding5 != null && (textInputEditText2 = addCounsellingDialogBinding5.csRelationship) != null) {
                        textInputEditText2.setText(data.getRequests().getImpactRelationship());
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding6 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding6 != null && (textInputEditText = addCounsellingDialogBinding6.csPhisical) != null) {
                        textInputEditText.setText(data.getRequests().getImpactPhysicallyEmotionally());
                    }
                    addCounsellingDialog.editResponse = data;
                    addCounsellingDialog.applySpinnerSelectionIfReady();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySpinnerSelectionIfReady() {
        final int i;
        Spinner spinner;
        Spinner spinner2;
        Spinner spinner3;
        ViewCounsellingResponse viewCounsellingResponse = this.editResponse;
        if (viewCounsellingResponse == null || getSpinnerAdapter().getItems().isEmpty() || getSpinnerAdapter2().getItems().isEmpty() || getSpinnerAdapter3().getItems().isEmpty()) {
            return;
        }
        Iterator<CounsellingTypes> it = getSpinnerAdapter().getItems().iterator();
        int i2 = 0;
        final int i3 = 0;
        while (true) {
            i = -1;
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getName(), viewCounsellingResponse.getRequests().getCounsellingType())) {
                break;
            } else {
                i3++;
            }
        }
        Iterator<CounsellingStatus> it2 = getSpinnerAdapter2().getItems().iterator();
        final int i4 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i4 = -1;
                break;
            } else if (Intrinsics.areEqual(it2.next().getName(), viewCounsellingResponse.getRequests().getCounsellingHistory())) {
                break;
            } else {
                i4++;
            }
        }
        Iterator<CounsellingStatus> it3 = getSpinnerAdapter3().getItems().iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            if (Intrinsics.areEqual(it3.next().getName(), viewCounsellingResponse.getRequests().getCounsellingSessionRequired())) {
                i = i2;
                break;
            }
            i2++;
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding = get_binding();
        if (addCounsellingDialogBinding != null && (spinner3 = addCounsellingDialogBinding.spinnerCouncellingType) != null) {
            spinner3.post(new Runnable() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AddCounsellingDialog.applySpinnerSelectionIfReady$lambda$5(this.f$0, i3);
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding2 = get_binding();
        if (addCounsellingDialogBinding2 != null && (spinner2 = addCounsellingDialogBinding2.spinnerCouncellingBefore) != null) {
            spinner2.post(new Runnable() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    AddCounsellingDialog.applySpinnerSelectionIfReady$lambda$6(this.f$0, i4);
                }
            });
        }
        AddCounsellingDialogBinding addCounsellingDialogBinding3 = get_binding();
        if (addCounsellingDialogBinding3 == null || (spinner = addCounsellingDialogBinding3.spinnerCouncellingMeet) == null) {
            return;
        }
        spinner.post(new Runnable() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AddCounsellingDialog.applySpinnerSelectionIfReady$lambda$7(this.f$0, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applySpinnerSelectionIfReady$lambda$5(AddCounsellingDialog this$0, int i) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddCounsellingDialogBinding addCounsellingDialogBinding = this$0.get_binding();
        if (addCounsellingDialogBinding != null && (spinner = addCounsellingDialogBinding.spinnerCouncellingType) != null) {
            spinner.setSelection(i);
        }
        this$0.type = this$0.getSpinnerAdapter().getItems().get(i).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applySpinnerSelectionIfReady$lambda$6(AddCounsellingDialog this$0, int i) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddCounsellingDialogBinding addCounsellingDialogBinding = this$0.get_binding();
        if (addCounsellingDialogBinding != null && (spinner = addCounsellingDialogBinding.spinnerCouncellingBefore) != null) {
            spinner.setSelection(i, false);
        }
        this$0.before = this$0.getSpinnerAdapter2().getItems().get(i).getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applySpinnerSelectionIfReady$lambda$7(AddCounsellingDialog this$0, int i) {
        Spinner spinner;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddCounsellingDialogBinding addCounsellingDialogBinding = this$0.get_binding();
        if (addCounsellingDialogBinding != null && (spinner = addCounsellingDialogBinding.spinnerCouncellingMeet) != null) {
            spinner.setSelection(i, false);
        }
        this$0.after = this$0.getSpinnerAdapter3().getItems().get(i).getId();
    }

    private final void listenProgressResponse() {
        getAddCounsellingViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends Float>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenProgressResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenProgressResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends Float> resource) {
                invoke2((Resource<Float>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<Float> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    } else {
                        if (i != 4) {
                            return;
                        }
                        AddCounsellingDialog.this.hideProgress();
                        return;
                    }
                }
                AddCounsellingDialog.this.hideProgress();
                Float data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    float fFloatValue = data.floatValue();
                    AddCounsellingDialogBinding addCounsellingDialogBinding = addCounsellingDialog.get_binding();
                    ProgressBar progressBar = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.uploadProgressbar : null;
                    if (progressBar != null) {
                        progressBar.setProgress((int) fFloatValue);
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding2 = addCounsellingDialog.get_binding();
                    TextView textView = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.progressText : null;
                    if (textView != null) {
                        textView.setText(((int) fFloatValue) + " %");
                    }
                    if (((int) fFloatValue) == 100) {
                        addCounsellingDialog.showProgress();
                        AddCounsellingDialogBinding addCounsellingDialogBinding3 = addCounsellingDialog.get_binding();
                        MaterialCardView materialCardView = addCounsellingDialogBinding3 != null ? addCounsellingDialogBinding3.progressView : null;
                        if (materialCardView == null) {
                            return;
                        }
                        materialCardView.setVisibility(8);
                    }
                }
            }
        }));
    }

    private final void listenAddResponse() {
        getAddCounsellingViewModel().getAddCounsellingResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenAddResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenAddResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
                MaterialCardView materialCardView;
                TextInputEditText etCsConcern;
                TextInputEditText etCsConcern2;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                        materialCardView = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.progressView : null;
                        if (materialCardView == null) {
                            return;
                        }
                        materialCardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    AddCounsellingDialogBinding addCounsellingDialogBinding2 = AddCounsellingDialog.this.get_binding();
                    materialCardView = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.progressView : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(8);
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding3 = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding3 == null || (textInputEditText = addCounsellingDialogBinding3.csRelationship) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    if (data.getSuccess()) {
                        AddCounsellingDialogBinding addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                        materialCardView = addCounsellingDialogBinding4 != null ? addCounsellingDialogBinding4.progressView : null;
                        if (materialCardView != null) {
                            materialCardView.setVisibility(8);
                        }
                        AddCounsellingDialogBinding addCounsellingDialogBinding5 = addCounsellingDialog.get_binding();
                        if (addCounsellingDialogBinding5 != null && (etCsConcern2 = addCounsellingDialogBinding5.etCsConcern) != null) {
                            Intrinsics.checkNotNullExpressionValue(etCsConcern2, "etCsConcern");
                            ToastExtKt.showSuccessToast(etCsConcern2, data.getMessage());
                        }
                        addCounsellingDialog.dismiss();
                        return;
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding6 = addCounsellingDialog.get_binding();
                    materialCardView = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.progressView : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(8);
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding7 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding7 == null || (etCsConcern = addCounsellingDialogBinding7.etCsConcern) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(etCsConcern, "etCsConcern");
                    ToastExtKt.showSuccessToast(etCsConcern, data.getError());
                }
            }
        }));
    }

    private final void listenReopenResponse() {
        getAddCounsellingViewModel().getReopenCounsellingResponse().observe(getViewLifecycleOwner(), new AddCounsellingDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.add.AddCounsellingDialog.listenReopenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.counselling.add.AddCounsellingDialog$listenReopenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: AddCounsellingDialog.kt */
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
                MaterialCardView materialCardView;
                TextInputEditText etCsConcern;
                TextInputEditText etCsConcern2;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddCounsellingDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddCounsellingDialog.this.hideProgress();
                        AddCounsellingDialogBinding addCounsellingDialogBinding = AddCounsellingDialog.this.get_binding();
                        materialCardView = addCounsellingDialogBinding != null ? addCounsellingDialogBinding.progressView : null;
                        if (materialCardView == null) {
                            return;
                        }
                        materialCardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddCounsellingDialog.this.hideProgress();
                    AddCounsellingDialogBinding addCounsellingDialogBinding2 = AddCounsellingDialog.this.get_binding();
                    materialCardView = addCounsellingDialogBinding2 != null ? addCounsellingDialogBinding2.progressView : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(8);
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding3 = AddCounsellingDialog.this.get_binding();
                    if (addCounsellingDialogBinding3 == null || (textInputEditText = addCounsellingDialogBinding3.csRelationship) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddCounsellingDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddCounsellingDialog addCounsellingDialog = AddCounsellingDialog.this;
                    if (data.getSuccess()) {
                        AddCounsellingDialogBinding addCounsellingDialogBinding4 = addCounsellingDialog.get_binding();
                        materialCardView = addCounsellingDialogBinding4 != null ? addCounsellingDialogBinding4.progressView : null;
                        if (materialCardView != null) {
                            materialCardView.setVisibility(8);
                        }
                        AddCounsellingDialogBinding addCounsellingDialogBinding5 = addCounsellingDialog.get_binding();
                        if (addCounsellingDialogBinding5 != null && (etCsConcern2 = addCounsellingDialogBinding5.etCsConcern) != null) {
                            Intrinsics.checkNotNullExpressionValue(etCsConcern2, "etCsConcern");
                            ToastExtKt.showSuccessToast(etCsConcern2, data.getMessage());
                        }
                        addCounsellingDialog.dismiss();
                        return;
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding6 = addCounsellingDialog.get_binding();
                    materialCardView = addCounsellingDialogBinding6 != null ? addCounsellingDialogBinding6.progressView : null;
                    if (materialCardView != null) {
                        materialCardView.setVisibility(8);
                    }
                    AddCounsellingDialogBinding addCounsellingDialogBinding7 = addCounsellingDialog.get_binding();
                    if (addCounsellingDialogBinding7 == null || (etCsConcern = addCounsellingDialogBinding7.etCsConcern) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(etCsConcern, "etCsConcern");
                    ToastExtKt.showSuccessToast(etCsConcern, data.getError());
                }
            }
        }));
    }

    public final void setCallBack(CounsellingFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddCounsellingListener addCounsellingListener = this.listener;
        if (addCounsellingListener != null) {
            addCounsellingListener.dismiss();
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