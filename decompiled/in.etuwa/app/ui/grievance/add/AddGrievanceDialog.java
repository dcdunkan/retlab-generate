package in.etuwa.app.ui.grievance.add;

import android.content.ClipData;
import android.content.ComponentCallbacks;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.grievance.type.GrievanceTypeResponse;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.databinding.AddGrievanceDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.grievance.GrievanceFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
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
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddGrievanceDialog.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 C2\u00020\u0001:\u0002BCB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u001fH\u0002J\"\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020\u001fH\u0016J\b\u00104\u001a\u00020\u001fH\u0016J\u0010\u00105\u001a\u00020\u001f2\u0006\u00106\u001a\u000207H\u0016J\u001a\u00108\u001a\u00020\u001f2\u0006\u00109\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u000e\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020?H\u0002J\b\u0010@\u001a\u00020\u001fH\u0014J\b\u0010A\u001a\u00020\u001fH\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001d\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006D"}, d2 = {"Lin/etuwa/app/ui/grievance/add/AddGrievanceDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/AddGrievanceDialogBinding;", "addGrievanceDialogViewModel", "Lin/etuwa/app/ui/grievance/add/AddGrievanceDialogViewModel;", "getAddGrievanceDialogViewModel", "()Lin/etuwa/app/ui/grievance/add/AddGrievanceDialogViewModel;", "addGrievanceDialogViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/AddGrievanceDialogBinding;", "id", "", "isReOpen", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/grievance/add/AddGrievanceDialog$AddGrievanceListener;", "pickFiles", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "spinnerAdapter", "Lin/etuwa/app/ui/grievance/add/GrievanceTypeSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/ui/grievance/add/GrievanceTypeSpinnerAdapter;", "spinnerAdapter$delegate", "type", "hideProgress", "", "listenAddResponse", "listenProgressResponse", "listenSpinner", "listenViewGrievance", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "context", "Lin/etuwa/app/ui/grievance/GrievanceFragment;", "setSelectedFiles", "path", "Landroid/net/Uri;", "setUp", "showProgress", "AddGrievanceListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddGrievanceDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddGrievanceDialogBinding _binding;

    /* renamed from: addGrievanceDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addGrievanceDialogViewModel;
    private String id;
    private boolean isReOpen;
    private AddGrievanceListener listener;
    private final ArrayList<File> pickFiles;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;
    private String type;

    /* compiled from: AddGrievanceDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/grievance/add/AddGrievanceDialog$AddGrievanceListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddGrievanceListener {
        void dismiss();
    }

    @JvmStatic
    public static final AddGrievanceDialog newInstance(String str, boolean z) {
        return INSTANCE.newInstance(str, z);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddGrievanceDialog() {
        final AddGrievanceDialog addGrievanceDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addGrievanceDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addGrievanceDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(addGrievanceDialog, Reflection.getOrCreateKotlinClass(AddGrievanceDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddGrievanceDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.type = "";
        final AddGrievanceDialog addGrievanceDialog2 = this;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AddGrievanceDialog.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<GrievanceTypeSpinnerAdapter>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.grievance.add.GrievanceTypeSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final GrievanceTypeSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = addGrievanceDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(GrievanceTypeSpinnerAdapter.class), b2, function02);
            }
        });
        this.pickFiles = new ArrayList<>();
    }

    private final AddGrievanceDialogViewModel getAddGrievanceDialogViewModel() {
        return (AddGrievanceDialogViewModel) this.addGrievanceDialogViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final AddGrievanceDialogBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GrievanceTypeSpinnerAdapter getSpinnerAdapter() {
        return (GrievanceTypeSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* compiled from: AddGrievanceDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/grievance/add/AddGrievanceDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/add/AddGrievanceDialog;", "id", "", "isReOpen", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddGrievanceDialog newInstance(String id, boolean isReOpen) {
            AddGrievanceDialog addGrievanceDialog = new AddGrievanceDialog();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            bundle.putBoolean("reopen", isReOpen);
            addGrievanceDialog.setArguments(bundle);
            return addGrievanceDialog;
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
        this._binding = AddGrievanceDialogBinding.inflate(inflater, container, false);
        AddGrievanceDialogBinding addGrievanceDialogBinding = get_binding();
        if (addGrievanceDialogBinding != null) {
            addGrievanceDialogBinding.setAddGrievanceDialogViewModel(getAddGrievanceDialogViewModel());
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding2 = get_binding();
        if (addGrievanceDialogBinding2 != null) {
            addGrievanceDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding3 = get_binding();
        if (addGrievanceDialogBinding3 != null) {
            return addGrievanceDialogBinding3.getRoot();
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
        AddGrievanceDialogBinding addGrievanceDialogBinding = get_binding();
        Spinner spinner = addGrievanceDialogBinding != null ? addGrievanceDialogBinding.spinnerGrievance : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSpinner();
        listenAddResponse();
        listenViewGrievance();
        listenProgressResponse();
        if (this.id != null) {
            getAddGrievanceDialogViewModel().viewGrievance(this.id);
            AddGrievanceDialogBinding addGrievanceDialogBinding2 = get_binding();
            TextView textView3 = addGrievanceDialogBinding2 != null ? addGrievanceDialogBinding2.grivTitle : null;
            if (textView3 != null) {
                textView3.setText("Edit Grievance");
            }
            AddGrievanceDialogBinding addGrievanceDialogBinding3 = get_binding();
            TextView textView4 = addGrievanceDialogBinding3 != null ? addGrievanceDialogBinding3.addGrievanceBtn : null;
            if (textView4 != null) {
                textView4.setText("Update Grievance");
            }
        }
        if (this.isReOpen) {
            AddGrievanceDialogBinding addGrievanceDialogBinding4 = get_binding();
            TextInputLayout textInputLayout = addGrievanceDialogBinding4 != null ? addGrievanceDialogBinding4.comntLayout : null;
            if (textInputLayout != null) {
                textInputLayout.setVisibility(0);
            }
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding5 = get_binding();
        Spinner spinner2 = addGrievanceDialogBinding5 != null ? addGrievanceDialogBinding5.spinnerGrievance : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$setUp$1
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    GrievanceTypeSpinnerAdapter spinnerAdapter;
                    AddGrievanceDialog addGrievanceDialog = AddGrievanceDialog.this;
                    spinnerAdapter = addGrievanceDialog.getSpinnerAdapter();
                    addGrievanceDialog.type = spinnerAdapter.getType(position).getId();
                }
            });
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding6 = get_binding();
        if (addGrievanceDialogBinding6 != null && (textView2 = addGrievanceDialogBinding6.uploadGrBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddGrievanceDialog.setUp$lambda$2(AddGrievanceDialog.this, view);
                }
            });
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding7 = get_binding();
        if (addGrievanceDialogBinding7 == null || (textView = addGrievanceDialogBinding7.addGrievanceBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddGrievanceDialog.setUp$lambda$3(AddGrievanceDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AddGrievanceDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AddGrievanceDialog this$0, View view) {
        TextInputEditText textInputEditText;
        TextInputEditText textInputEditText2;
        TextInputEditText textInputEditText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap<String, RequestBody> hashMap = new HashMap<>();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType mediaType = MultipartBody.FORM;
        String str = this$0.id;
        if (str == null) {
            str = "";
        }
        RequestBody create = companion.create(mediaType, str);
        HashMap<String, RequestBody> hashMap2 = hashMap;
        hashMap2.put("Grievance[grievance_type]", RequestBody.INSTANCE.create(MultipartBody.FORM, this$0.type));
        RequestBody.Companion companion2 = RequestBody.INSTANCE;
        MediaType mediaType2 = MultipartBody.FORM;
        AddGrievanceDialogBinding addGrievanceDialogBinding = this$0.get_binding();
        Editable editable = null;
        hashMap2.put("Grievance[subject]", companion2.create(mediaType2, String.valueOf((addGrievanceDialogBinding == null || (textInputEditText3 = addGrievanceDialogBinding.etGrSubject) == null) ? null : textInputEditText3.getText())));
        RequestBody.Companion companion3 = RequestBody.INSTANCE;
        MediaType mediaType3 = MultipartBody.FORM;
        AddGrievanceDialogBinding addGrievanceDialogBinding2 = this$0.get_binding();
        hashMap2.put("Grievance[description]", companion3.create(mediaType3, String.valueOf((addGrievanceDialogBinding2 == null || (textInputEditText2 = addGrievanceDialogBinding2.grComplaint) == null) ? null : textInputEditText2.getText())));
        if (this$0.pickFiles.size() != 0) {
            AddGrievanceDialogBinding addGrievanceDialogBinding3 = this$0.get_binding();
            CardView cardView = addGrievanceDialogBinding3 != null ? addGrievanceDialogBinding3.progressView : null;
            if (cardView != null) {
                cardView.setVisibility(0);
            }
        }
        String str2 = this$0.id;
        if (str2 == null || str2.length() == 0) {
            this$0.getAddGrievanceDialogViewModel().addGrievance(hashMap, this$0.pickFiles);
            return;
        }
        if (this$0.isReOpen) {
            RequestBody.Companion companion4 = RequestBody.INSTANCE;
            MediaType mediaType4 = MultipartBody.FORM;
            AddGrievanceDialogBinding addGrievanceDialogBinding4 = this$0.get_binding();
            if (addGrievanceDialogBinding4 != null && (textInputEditText = addGrievanceDialogBinding4.grComment) != null) {
                editable = textInputEditText.getText();
            }
            hashMap2.put("Grievance[comments]", companion4.create(mediaType4, String.valueOf(editable)));
        }
        this$0.getAddGrievanceDialogViewModel().updateGrievance(create, hashMap, this$0.pickFiles);
    }

    private final void listenSpinner() {
        getAddGrievanceDialogViewModel().getTypeResponse().observe(getViewLifecycleOwner(), new AddGrievanceDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends GrievanceTypeResponse>, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$listenSpinner$1

            /* compiled from: AddGrievanceDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends GrievanceTypeResponse> resource) {
                invoke2((Resource<GrievanceTypeResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<GrievanceTypeResponse> resource) {
                GrievanceTypeSpinnerAdapter spinnerAdapter;
                AddGrievanceDialogBinding addGrievanceDialogBinding;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddGrievanceDialog.this.hideProgress();
                    GrievanceTypeResponse data = resource.getData();
                    if (data != null) {
                        spinnerAdapter = AddGrievanceDialog.this.getSpinnerAdapter();
                        spinnerAdapter.addItems(data.getGTypes());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddGrievanceDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddGrievanceDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddGrievanceDialog.this.hideProgress();
                addGrievanceDialogBinding = AddGrievanceDialog.this.get_binding();
                if (addGrievanceDialogBinding == null || (spinner = addGrievanceDialogBinding.spinnerGrievance) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenViewGrievance() {
        getAddGrievanceDialogViewModel().getViewResponse().observe(getViewLifecycleOwner(), new AddGrievanceDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewGrievanceResponse>, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$listenViewGrievance$1

            /* compiled from: AddGrievanceDialog.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewGrievanceResponse> resource) {
                invoke2((Resource<ViewGrievanceResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewGrievanceResponse> resource) {
                AddGrievanceDialogBinding addGrievanceDialogBinding;
                AddGrievanceDialogBinding addGrievanceDialogBinding2;
                TextInputEditText textInputEditText;
                TextInputEditText textInputEditText2;
                AddGrievanceDialogBinding addGrievanceDialogBinding3;
                Spinner spinner;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    AddGrievanceDialog.this.hideProgress();
                    ViewGrievanceResponse data = resource.getData();
                    if (data != null) {
                        AddGrievanceDialog addGrievanceDialog = AddGrievanceDialog.this;
                        addGrievanceDialogBinding = addGrievanceDialog.get_binding();
                        if (addGrievanceDialogBinding != null && (textInputEditText2 = addGrievanceDialogBinding.etGrSubject) != null) {
                            textInputEditText2.setText(data.getGrievance().getSubject());
                        }
                        addGrievanceDialogBinding2 = addGrievanceDialog.get_binding();
                        if (addGrievanceDialogBinding2 == null || (textInputEditText = addGrievanceDialogBinding2.grComplaint) == null) {
                            return;
                        }
                        textInputEditText.setText(data.getGrievance().getDescription());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    AddGrievanceDialog.this.showProgress();
                    return;
                }
                if (i == 3) {
                    AddGrievanceDialog.this.hideProgress();
                    return;
                }
                if (i != 4) {
                    return;
                }
                AddGrievanceDialog.this.hideProgress();
                addGrievanceDialogBinding3 = AddGrievanceDialog.this.get_binding();
                if (addGrievanceDialogBinding3 == null || (spinner = addGrievanceDialogBinding3.spinnerGrievance) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(spinner, message);
            }
        }));
    }

    private final void listenProgressResponse() {
        getAddGrievanceDialogViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new AddGrievanceDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends Float>, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$listenProgressResponse$1

            /* compiled from: AddGrievanceDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<Float> resource) {
                AddGrievanceDialogBinding addGrievanceDialogBinding;
                AddGrievanceDialogBinding addGrievanceDialogBinding2;
                AddGrievanceDialogBinding addGrievanceDialogBinding3;
                AddGrievanceDialogBinding addGrievanceDialogBinding4;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 3) {
                        AddGrievanceDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddGrievanceDialog.this.hideProgress();
                    addGrievanceDialogBinding4 = AddGrievanceDialog.this.get_binding();
                    if (addGrievanceDialogBinding4 == null || (textView = addGrievanceDialogBinding4.grUploadPath) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView, message);
                    return;
                }
                AddGrievanceDialog.this.hideProgress();
                Float data = resource.getData();
                if (data != null) {
                    AddGrievanceDialog addGrievanceDialog = AddGrievanceDialog.this;
                    float floatValue = data.floatValue();
                    addGrievanceDialogBinding = addGrievanceDialog.get_binding();
                    ProgressBar progressBar = addGrievanceDialogBinding != null ? addGrievanceDialogBinding.uploadProgressbar : null;
                    if (progressBar != null) {
                        progressBar.setProgress((int) floatValue);
                    }
                    addGrievanceDialogBinding2 = addGrievanceDialog.get_binding();
                    TextView textView2 = addGrievanceDialogBinding2 != null ? addGrievanceDialogBinding2.progressText : null;
                    if (textView2 != null) {
                        textView2.setText(((int) floatValue) + " %");
                    }
                    if (((int) floatValue) == 100) {
                        addGrievanceDialog.showProgress();
                        addGrievanceDialogBinding3 = addGrievanceDialog.get_binding();
                        CardView cardView = addGrievanceDialogBinding3 != null ? addGrievanceDialogBinding3.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                    }
                }
            }
        }));
    }

    private final void listenAddResponse() {
        getAddGrievanceDialogViewModel().getAddGrievanceResponse().observe(getViewLifecycleOwner(), new AddGrievanceDialogKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends SuccessResponse>, Unit>() { // from class: in.etuwa.app.ui.grievance.add.AddGrievanceDialog$listenAddResponse$1

            /* compiled from: AddGrievanceDialog.kt */
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
                AddGrievanceDialogBinding addGrievanceDialogBinding;
                CardView cardView;
                AddGrievanceDialogBinding addGrievanceDialogBinding2;
                TextInputEditText grComplaint;
                AddGrievanceDialogBinding addGrievanceDialogBinding3;
                AddGrievanceDialogBinding addGrievanceDialogBinding4;
                TextInputEditText grComplaint2;
                AddGrievanceDialogBinding addGrievanceDialogBinding5;
                AddGrievanceDialogBinding addGrievanceDialogBinding6;
                AddGrievanceDialogBinding addGrievanceDialogBinding7;
                TextInputEditText textInputEditText;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        AddGrievanceDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        AddGrievanceDialog.this.hideProgress();
                        addGrievanceDialogBinding5 = AddGrievanceDialog.this.get_binding();
                        cardView = addGrievanceDialogBinding5 != null ? addGrievanceDialogBinding5.progressView : null;
                        if (cardView == null) {
                            return;
                        }
                        cardView.setVisibility(8);
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    AddGrievanceDialog.this.hideProgress();
                    addGrievanceDialogBinding6 = AddGrievanceDialog.this.get_binding();
                    cardView = addGrievanceDialogBinding6 != null ? addGrievanceDialogBinding6.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addGrievanceDialogBinding7 = AddGrievanceDialog.this.get_binding();
                    if (addGrievanceDialogBinding7 == null || (textInputEditText = addGrievanceDialogBinding7.grComplaint) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textInputEditText, message);
                    return;
                }
                AddGrievanceDialog.this.hideProgress();
                SuccessResponse data = resource.getData();
                if (data != null) {
                    AddGrievanceDialog addGrievanceDialog = AddGrievanceDialog.this;
                    if (data.getSuccess()) {
                        addGrievanceDialogBinding3 = addGrievanceDialog.get_binding();
                        cardView = addGrievanceDialogBinding3 != null ? addGrievanceDialogBinding3.progressView : null;
                        if (cardView != null) {
                            cardView.setVisibility(8);
                        }
                        addGrievanceDialogBinding4 = addGrievanceDialog.get_binding();
                        if (addGrievanceDialogBinding4 != null && (grComplaint2 = addGrievanceDialogBinding4.grComplaint) != null) {
                            Intrinsics.checkNotNullExpressionValue(grComplaint2, "grComplaint");
                            ToastExtKt.showSuccessToast(grComplaint2, data.getMessage());
                        }
                        addGrievanceDialog.dismiss();
                        return;
                    }
                    addGrievanceDialogBinding = addGrievanceDialog.get_binding();
                    cardView = addGrievanceDialogBinding != null ? addGrievanceDialogBinding.progressView : null;
                    if (cardView != null) {
                        cardView.setVisibility(8);
                    }
                    addGrievanceDialogBinding2 = addGrievanceDialog.get_binding();
                    if (addGrievanceDialogBinding2 == null || (grComplaint = addGrievanceDialogBinding2.grComplaint) == null) {
                        return;
                    }
                    Intrinsics.checkNotNullExpressionValue(grComplaint, "grComplaint");
                    ToastExtKt.showSuccessToast(grComplaint, data.getError());
                }
            }
        }));
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Context context;
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        ContentResolver contentResolver3;
        ParcelFileDescriptor openFileDescriptor2;
        String str2;
        ContentResolver contentResolver4;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            this.pickFiles.clear();
            AddGrievanceDialogBinding addGrievanceDialogBinding = get_binding();
            TextView textView = addGrievanceDialogBinding != null ? addGrievanceDialogBinding.grUploadPath : null;
            if (textView != null) {
                textView.setText("");
            }
            if (data.getClipData() != null) {
                ClipData clipData = data.getClipData();
                Intrinsics.checkNotNull(clipData);
                int itemCount = clipData.getItemCount();
                for (int i = 0; i < itemCount; i++) {
                    ClipData clipData2 = data.getClipData();
                    Intrinsics.checkNotNull(clipData2);
                    Uri uri = clipData2.getItemAt(i).getUri();
                    Context context2 = getContext();
                    if (context2 != null && (contentResolver3 = context2.getContentResolver()) != null && (openFileDescriptor2 = contentResolver3.openFileDescriptor(uri, "r", null)) != null) {
                        Context context3 = getContext();
                        File cacheDir = context3 != null ? context3.getCacheDir() : null;
                        Context context4 = getContext();
                        if (context4 == null || (contentResolver4 = context4.getContentResolver()) == null) {
                            str2 = null;
                        } else {
                            Intrinsics.checkNotNullExpressionValue(uri, "uri");
                            str2 = ResolvUtilKt.getFileName(contentResolver4, uri);
                        }
                        File file = new File(cacheDir, str2);
                        ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor2.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                        this.pickFiles.add(file);
                        Intrinsics.checkNotNullExpressionValue(uri, "uri");
                        setSelectedFiles(uri);
                    }
                    return;
                }
                return;
            }
            Uri data2 = data.getData();
            if (data2 != null && (context = getContext()) != null && (contentResolver = context.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                Context context5 = getContext();
                File cacheDir2 = context5 != null ? context5.getCacheDir() : null;
                Context context6 = getContext();
                if (context6 == null || (contentResolver2 = context6.getContentResolver()) == null) {
                    str = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                    str = ResolvUtilKt.getFileName(contentResolver2, data2);
                }
                File file2 = new File(cacheDir2, str);
                ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file2), 0, 2, null);
                this.pickFiles.add(file2);
                setSelectedFiles(data2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void setSelectedFiles(Uri path) {
        ContentResolver contentResolver;
        ContentResolver contentResolver2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        AddGrievanceDialogBinding addGrievanceDialogBinding = get_binding();
        String str = null;
        if (!Intrinsics.areEqual((addGrievanceDialogBinding == null || (textView3 = addGrievanceDialogBinding.grUploadPath) == null) ? null : textView3.getText(), "")) {
            AddGrievanceDialogBinding addGrievanceDialogBinding2 = get_binding();
            if (!Intrinsics.areEqual((addGrievanceDialogBinding2 == null || (textView2 = addGrievanceDialogBinding2.grUploadPath) == null) ? null : textView2.getText(), "No File Selected")) {
                AddGrievanceDialogBinding addGrievanceDialogBinding3 = get_binding();
                TextView textView4 = addGrievanceDialogBinding3 != null ? addGrievanceDialogBinding3.grUploadPath : null;
                if (textView4 == null) {
                    return;
                }
                AddGrievanceDialogBinding addGrievanceDialogBinding4 = get_binding();
                CharSequence text = (addGrievanceDialogBinding4 == null || (textView = addGrievanceDialogBinding4.grUploadPath) == null) ? null : textView.getText();
                Context context = getContext();
                if (context != null && (contentResolver2 = context.getContentResolver()) != null) {
                    str = ResolvUtilKt.getFileName(contentResolver2, path);
                }
                textView4.setText(((Object) text) + IOUtils.LINE_SEPARATOR_UNIX + str);
                return;
            }
        }
        AddGrievanceDialogBinding addGrievanceDialogBinding5 = get_binding();
        TextView textView5 = addGrievanceDialogBinding5 != null ? addGrievanceDialogBinding5.grUploadPath : null;
        if (textView5 == null) {
            return;
        }
        Context context2 = getContext();
        if (context2 != null && (contentResolver = context2.getContentResolver()) != null) {
            str = ResolvUtilKt.getFileName(contentResolver, path);
        }
        textView5.setText(String.valueOf(str));
    }

    public final void setCallBack(GrievanceFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        AddGrievanceListener addGrievanceListener = this.listener;
        if (addGrievanceListener != null) {
            addGrievanceListener.dismiss();
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