package in.etuwa.app.ui.leave.medical.add;

import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.cli.HelpFormatter;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.databinding.AddMedicalLeaveBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.leave.medical.MedicalFragment;
import in.etuwa.app.utils.ResolvUtilKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AddMedicalLeave.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0002-.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\u001a\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u000e\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\u0013H\u0015J\b\u0010,\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeave;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/AddMedicalLeaveBinding;", "addMedicalLeaveViewModel", "Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeaveViewModel;", "getAddMedicalLeaveViewModel", "()Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeaveViewModel;", "addMedicalLeaveViewModel$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/AddMedicalLeaveBinding;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeave$AddLeaveCallBack;", "pickFile", "Ljava/io/File;", "hideProgress", "", "listenProgressResponse", "listenResponse", "onActivityResult", "requestCode", "", "resultCode", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setAddLeaveCallBack", "context", "Lin/etuwa/app/ui/leave/medical/MedicalFragment;", "setUp", "showProgress", "AddLeaveCallBack", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddMedicalLeave extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AddMedicalLeaveBinding _binding;

    /* renamed from: addMedicalLeaveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy addMedicalLeaveViewModel;
    private AddLeaveCallBack listener;
    private File pickFile;

    /* compiled from: AddMedicalLeave.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeave$AddLeaveCallBack;", "", "onDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface AddLeaveCallBack {
        void onDismiss();
    }

    /* compiled from: AddMedicalLeave.kt */
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
    public static final AddMedicalLeave newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public AddMedicalLeave() {
        final AddMedicalLeave addMedicalLeave = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(addMedicalLeave);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.addMedicalLeaveViewModel = FragmentViewModelLazyKt.createViewModelLazy(addMedicalLeave, Reflection.getOrCreateKotlinClass(AddMedicalLeaveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AddMedicalLeaveViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final AddMedicalLeaveViewModel getAddMedicalLeaveViewModel() {
        return (AddMedicalLeaveViewModel) this.addMedicalLeaveViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final AddMedicalLeaveBinding get_binding() {
        return this._binding;
    }

    /* compiled from: AddMedicalLeave.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeave$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/leave/medical/add/AddMedicalLeave;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AddMedicalLeave newInstance() {
            return new AddMedicalLeave();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AddMedicalLeaveBinding.inflate(inflater, container, false);
        AddMedicalLeaveBinding addMedicalLeaveBinding = get_binding();
        if (addMedicalLeaveBinding != null) {
            addMedicalLeaveBinding.setAddMedicalLeaveViewModel(getAddMedicalLeaveViewModel());
        }
        AddMedicalLeaveBinding addMedicalLeaveBinding2 = get_binding();
        if (addMedicalLeaveBinding2 != null) {
            addMedicalLeaveBinding2.setLifecycleOwner(this);
        }
        AddMedicalLeaveBinding addMedicalLeaveBinding3 = get_binding();
        if (addMedicalLeaveBinding3 != null) {
            return addMedicalLeaveBinding3.getRoot();
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
        Calendar calendar = Calendar.getInstance();
        final int i = calendar.get(1);
        final int i2 = calendar.get(2);
        final int i3 = calendar.get(5);
        listenResponse();
        listenProgressResponse();
        AddMedicalLeaveBinding addMedicalLeaveBinding = get_binding();
        if (addMedicalLeaveBinding != null && (textView4 = addMedicalLeaveBinding.fromDate) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMedicalLeave.setUp$lambda$1(AddMedicalLeave.this, i, i2, i3, view);
                }
            });
        }
        AddMedicalLeaveBinding addMedicalLeaveBinding2 = get_binding();
        if (addMedicalLeaveBinding2 != null && (textView3 = addMedicalLeaveBinding2.toDate) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMedicalLeave.setUp$lambda$3(AddMedicalLeave.this, i, i2, i3, view);
                }
            });
        }
        AddMedicalLeaveBinding addMedicalLeaveBinding3 = get_binding();
        if (addMedicalLeaveBinding3 != null && (textView2 = addMedicalLeaveBinding3.completionSelect) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AddMedicalLeave.setUp$lambda$5(AddMedicalLeave.this, view);
                }
            });
        }
        AddMedicalLeaveBinding addMedicalLeaveBinding4 = get_binding();
        if (addMedicalLeaveBinding4 == null || (textView = addMedicalLeaveBinding4.applyBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddMedicalLeave.setUp$lambda$6(AddMedicalLeave.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(final AddMedicalLeave this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda5
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddMedicalLeave.setUp$lambda$1$lambda$0(AddMedicalLeave.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1$lambda$0(AddMedicalLeave this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddMedicalLeaveBinding addMedicalLeaveBinding = this$0.get_binding();
        TextView textView = addMedicalLeaveBinding != null ? addMedicalLeaveBinding.fromDate : null;
        if (textView == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(final AddMedicalLeave this$0, int i, int i2, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        new DatePickerDialog(this$0.requireContext(), new DatePickerDialog.OnDateSetListener() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda6
            @Override // android.app.DatePickerDialog.OnDateSetListener
            public final void onDateSet(DatePicker datePicker, int i4, int i5, int i6) {
                AddMedicalLeave.setUp$lambda$3$lambda$2(AddMedicalLeave.this, datePicker, i4, i5, i6);
            }
        }, i, i2, i3).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3$lambda$2(AddMedicalLeave this$0, DatePicker datePicker, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AddMedicalLeaveBinding addMedicalLeaveBinding = this$0.get_binding();
        TextView textView = addMedicalLeaveBinding != null ? addMedicalLeaveBinding.toDate : null;
        if (textView == null) {
            return;
        }
        textView.setText(i + HelpFormatter.DEFAULT_OPT_PREFIX + (i2 + 1) + HelpFormatter.DEFAULT_OPT_PREFIX + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(AddMedicalLeave this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.setType("*/*");
        this$0.startActivityForResult(Intent.createChooser(intent, "Select a file"), 111);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$6(AddMedicalLeave this$0, View view) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        TextInputEditText textInputEditText;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextInputEditText textInputEditText2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            File file = this$0.pickFile;
            if (file == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                file = null;
            }
            if (file.exists()) {
                File file2 = this$0.pickFile;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                    file2 = null;
                }
                if (file2.length() / 1024 <= 200) {
                    this$0.setCancelable(false);
                    AddMedicalLeaveBinding addMedicalLeaveBinding = this$0.get_binding();
                    if (Intrinsics.areEqual(String.valueOf((addMedicalLeaveBinding == null || (textInputEditText2 = addMedicalLeaveBinding.etReason) == null) ? null : textInputEditText2.getText()), "")) {
                        AddMedicalLeaveBinding addMedicalLeaveBinding2 = this$0.get_binding();
                        if (addMedicalLeaveBinding2 == null || (textView9 = addMedicalLeaveBinding2.completionSelect) == null) {
                            return;
                        }
                        ToastExtKt.showInfoToast(textView9, "Reason Cannot be empty");
                        return;
                    }
                    AddMedicalLeaveBinding addMedicalLeaveBinding3 = this$0.get_binding();
                    if (!Intrinsics.areEqual(String.valueOf((addMedicalLeaveBinding3 == null || (textView8 = addMedicalLeaveBinding3.fromDate) == null) ? null : textView8.getText()), "")) {
                        AddMedicalLeaveBinding addMedicalLeaveBinding4 = this$0.get_binding();
                        if (!Intrinsics.areEqual(String.valueOf((addMedicalLeaveBinding4 == null || (textView7 = addMedicalLeaveBinding4.toDate) == null) ? null : textView7.getText()), "")) {
                            AddMedicalLeaveViewModel addMedicalLeaveViewModel = this$0.getAddMedicalLeaveViewModel();
                            AddMedicalLeaveBinding addMedicalLeaveBinding5 = this$0.get_binding();
                            String valueOf = String.valueOf((addMedicalLeaveBinding5 == null || (textInputEditText = addMedicalLeaveBinding5.etReason) == null) ? null : textInputEditText.getText());
                            AddMedicalLeaveBinding addMedicalLeaveBinding6 = this$0.get_binding();
                            String valueOf2 = String.valueOf((addMedicalLeaveBinding6 == null || (textView6 = addMedicalLeaveBinding6.fromDate) == null) ? null : textView6.getText());
                            AddMedicalLeaveBinding addMedicalLeaveBinding7 = this$0.get_binding();
                            String valueOf3 = String.valueOf((addMedicalLeaveBinding7 == null || (textView5 = addMedicalLeaveBinding7.toDate) == null) ? null : textView5.getText());
                            File file3 = this$0.pickFile;
                            if (file3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("pickFile");
                                file3 = null;
                            }
                            addMedicalLeaveViewModel.applyMedicalLeave(valueOf, valueOf2, valueOf3, file3);
                            AddMedicalLeaveBinding addMedicalLeaveBinding8 = this$0.get_binding();
                            LinearLayout linearLayout = addMedicalLeaveBinding8 != null ? addMedicalLeaveBinding8.completionCard : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(8);
                            }
                            AddMedicalLeaveBinding addMedicalLeaveBinding9 = this$0.get_binding();
                            LinearLayout linearLayout2 = addMedicalLeaveBinding9 != null ? addMedicalLeaveBinding9.progressView : null;
                            if (linearLayout2 == null) {
                                return;
                            }
                            linearLayout2.setVisibility(0);
                            return;
                        }
                    }
                    AddMedicalLeaveBinding addMedicalLeaveBinding10 = this$0.get_binding();
                    if (addMedicalLeaveBinding10 == null || (textView4 = addMedicalLeaveBinding10.completionSelect) == null) {
                        return;
                    }
                    ToastExtKt.showInfoToast(textView4, "please choose dates");
                    return;
                }
                AddMedicalLeaveBinding addMedicalLeaveBinding11 = this$0.get_binding();
                if (addMedicalLeaveBinding11 == null || (textView3 = addMedicalLeaveBinding11.completionSelect) == null) {
                    return;
                }
                ToastExtKt.showInfoToast(textView3, "File Size Limit Is 200KB");
                return;
            }
            AddMedicalLeaveBinding addMedicalLeaveBinding12 = this$0.get_binding();
            if (addMedicalLeaveBinding12 == null || (textView2 = addMedicalLeaveBinding12.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView2, "Please Select A File");
        } catch (Exception unused) {
            AddMedicalLeaveBinding addMedicalLeaveBinding13 = this$0.get_binding();
            if (addMedicalLeaveBinding13 == null || (textView = addMedicalLeaveBinding13.completionSelect) == null) {
                return;
            }
            ToastExtKt.showInfoToast(textView, "Something went wrong.");
        }
    }

    private final void listenResponse() {
        getAddMedicalLeaveViewModel().getUploadResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMedicalLeave.listenResponse$lambda$8(AddMedicalLeave.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$8(AddMedicalLeave this$0, Resource resource) {
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
            AddMedicalLeaveBinding addMedicalLeaveBinding = this$0.get_binding();
            if (addMedicalLeaveBinding != null && (textView = addMedicalLeaveBinding.completionFileName) != null) {
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
            this$0.dismiss();
            AddLeaveCallBack addLeaveCallBack = this$0.listener;
            if (addLeaveCallBack != null) {
                addLeaveCallBack.onDismiss();
                return;
            }
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getSuccess()) {
                AddMedicalLeaveBinding addMedicalLeaveBinding2 = this$0.get_binding();
                if (addMedicalLeaveBinding2 != null && (completionFileName2 = addMedicalLeaveBinding2.completionFileName) != null) {
                    Intrinsics.checkNotNullExpressionValue(completionFileName2, "completionFileName");
                    ToastExtKt.showSuccessToast(completionFileName2, successResponse.getMessage());
                }
                AddLeaveCallBack addLeaveCallBack2 = this$0.listener;
                if (addLeaveCallBack2 != null) {
                    addLeaveCallBack2.onDismiss();
                }
                this$0.dismiss();
                return;
            }
            AddMedicalLeaveBinding addMedicalLeaveBinding3 = this$0.get_binding();
            if (addMedicalLeaveBinding3 != null && (completionFileName = addMedicalLeaveBinding3.completionFileName) != null) {
                Intrinsics.checkNotNullExpressionValue(completionFileName, "completionFileName");
                ToastExtKt.showErrorToast(completionFileName, "Something went Wrong!!");
            }
            AddLeaveCallBack addLeaveCallBack3 = this$0.listener;
            if (addLeaveCallBack3 != null) {
                addLeaveCallBack3.onDismiss();
            }
            this$0.dismiss();
        }
    }

    private final void listenProgressResponse() {
        getAddMedicalLeaveViewModel().getProgressResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.leave.medical.add.AddMedicalLeave$$ExternalSyntheticLambda7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddMedicalLeave.listenProgressResponse$lambda$10(AddMedicalLeave.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenProgressResponse$lambda$10(AddMedicalLeave this$0, Resource resource) {
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
            AddMedicalLeaveBinding addMedicalLeaveBinding = this$0.get_binding();
            if (addMedicalLeaveBinding == null || (textView = addMedicalLeaveBinding.completionFileName) == null) {
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
            float floatValue = f.floatValue();
            AddMedicalLeaveBinding addMedicalLeaveBinding2 = this$0.get_binding();
            ProgressBar progressBar = addMedicalLeaveBinding2 != null ? addMedicalLeaveBinding2.uploadProgressbar : null;
            if (progressBar != null) {
                progressBar.setProgress((int) floatValue);
            }
            AddMedicalLeaveBinding addMedicalLeaveBinding3 = this$0.get_binding();
            TextView textView2 = addMedicalLeaveBinding3 != null ? addMedicalLeaveBinding3.progressText : null;
            if (textView2 != null) {
                textView2.setText(((int) floatValue) + " %");
            }
            if (((int) floatValue) == 100) {
                this$0.showProgress();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ContentResolver contentResolver;
        ParcelFileDescriptor openFileDescriptor;
        String str;
        ContentResolver contentResolver2;
        String str2;
        ContentResolver contentResolver3;
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != -1 || data == null) {
            return;
        }
        try {
            Uri data2 = data.getData();
            if (data2 != null) {
                AddMedicalLeaveBinding addMedicalLeaveBinding = get_binding();
                TextView textView = addMedicalLeaveBinding != null ? addMedicalLeaveBinding.completionFileName : null;
                if (textView != null) {
                    Context context = getContext();
                    if (context == null || (contentResolver3 = context.getContentResolver()) == null) {
                        str2 = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver3, "contentResolver");
                        str2 = ResolvUtilKt.getFileName(contentResolver3, data2);
                    }
                    textView.setText("File : " + str2);
                }
                Context context2 = getContext();
                if (context2 != null && (contentResolver = context2.getContentResolver()) != null && (openFileDescriptor = contentResolver.openFileDescriptor(data2, "r", null)) != null) {
                    Intrinsics.checkNotNullExpressionValue(openFileDescriptor, "context?.contentResolver…  it, \"r\", null)?: return");
                    Context context3 = getContext();
                    File cacheDir = context3 != null ? context3.getCacheDir() : null;
                    Context context4 = getContext();
                    if (context4 == null || (contentResolver2 = context4.getContentResolver()) == null) {
                        str = null;
                    } else {
                        Intrinsics.checkNotNullExpressionValue(contentResolver2, "contentResolver");
                        str = ResolvUtilKt.getFileName(contentResolver2, data2);
                    }
                    File file = new File(cacheDir, str);
                    ByteStreamsKt.copyTo$default(new FileInputStream(openFileDescriptor.getFileDescriptor()), new FileOutputStream(file), 0, 2, null);
                    this.pickFile = file;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void setAddLeaveCallBack(MedicalFragment context) {
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
}