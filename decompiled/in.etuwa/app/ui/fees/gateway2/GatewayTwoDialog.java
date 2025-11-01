package in.etuwa.app.ui.fees.gateway2;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.io.IOUtils;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.databinding.DialogGatewayTwoBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.utils.ToastExtKt;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: GatewayTwoDialog.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J0\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ(\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015J\b\u0010 \u001a\u00020\u0013H\u0014J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J&\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\u001a\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010/\u001a\u00020\u0013H\u0015J\b\u00100\u001a\u00020\u0013H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lin/etuwa/app/ui/fees/gateway2/GatewayTwoDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogGatewayTwoBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogGatewayTwoBinding;", "gatewayTwoViewModel", "Lin/etuwa/app/ui/fees/gateway2/GatewayTwoViewModel;", "getGatewayTwoViewModel", "()Lin/etuwa/app/ui/fees/gateway2/GatewayTwoViewModel;", "gatewayTwoViewModel$delegate", "Lkotlin/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "url", "", "dismiss", "", "distributeUniqueNumbers", "", "", "", "start", "end", "countPerAccount", "", "generatePdf", "context", "Landroid/content/Context;", "accountData", "hideProgress", "onAttach", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GatewayTwoDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogGatewayTwoBinding _binding;

    /* renamed from: gatewayTwoViewModel$delegate, reason: from kotlin metadata */
    private final Lazy gatewayTwoViewModel;
    private MainCallBackListener listener;
    private String url;

    @JvmStatic
    public static final GatewayTwoDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public GatewayTwoDialog() {
        final GatewayTwoDialog gatewayTwoDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.fees.gateway2.GatewayTwoDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(gatewayTwoDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.gatewayTwoViewModel = FragmentViewModelLazyKt.createViewModelLazy(gatewayTwoDialog, Reflection.getOrCreateKotlinClass(GatewayTwoViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.fees.gateway2.GatewayTwoDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.fees.gateway2.GatewayTwoDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(GatewayTwoViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final GatewayTwoViewModel getGatewayTwoViewModel() {
        return (GatewayTwoViewModel) this.gatewayTwoViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogGatewayTwoBinding get_binding() {
        return this._binding;
    }

    /* compiled from: GatewayTwoDialog.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/fees/gateway2/GatewayTwoDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/fees/gateway2/GatewayTwoDialog;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GatewayTwoDialog newInstance() {
            GatewayTwoDialog gatewayTwoDialog = new GatewayTwoDialog();
            gatewayTwoDialog.setArguments(new Bundle());
            return gatewayTwoDialog;
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
        this._binding = DialogGatewayTwoBinding.inflate(inflater, container, false);
        DialogGatewayTwoBinding dialogGatewayTwoBinding = get_binding();
        if (dialogGatewayTwoBinding != null) {
            dialogGatewayTwoBinding.setGatewayTwoViewModel(getGatewayTwoViewModel());
        }
        DialogGatewayTwoBinding dialogGatewayTwoBinding2 = get_binding();
        if (dialogGatewayTwoBinding2 != null) {
            dialogGatewayTwoBinding2.setLifecycleOwner(this);
        }
        DialogGatewayTwoBinding dialogGatewayTwoBinding3 = get_binding();
        if (dialogGatewayTwoBinding3 != null) {
            return dialogGatewayTwoBinding3.getRoot();
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
        DialogGatewayTwoBinding dialogGatewayTwoBinding = get_binding();
        if (dialogGatewayTwoBinding == null || (textView = dialogGatewayTwoBinding.generateBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.fees.gateway2.GatewayTwoDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GatewayTwoDialog.setUp$lambda$1(GatewayTwoDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(GatewayTwoDialog this$0, View view) {
        TextView textView;
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        Editable text;
        EditText editText6;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogGatewayTwoBinding dialogGatewayTwoBinding = this$0.get_binding();
        Editable editable = null;
        if (!Intrinsics.areEqual(String.valueOf((dialogGatewayTwoBinding == null || (editText6 = dialogGatewayTwoBinding.start) == null) ? null : editText6.getText()), "")) {
            DialogGatewayTwoBinding dialogGatewayTwoBinding2 = this$0.get_binding();
            if (!Intrinsics.areEqual((dialogGatewayTwoBinding2 == null || (editText5 = dialogGatewayTwoBinding2.end) == null || (text = editText5.getText()) == null) ? null : text.toString(), "")) {
                DialogGatewayTwoBinding dialogGatewayTwoBinding3 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogGatewayTwoBinding3 == null || (editText4 = dialogGatewayTwoBinding3.noOfEntries) == null) ? null : editText4.getText()), "")) {
                    DialogGatewayTwoBinding dialogGatewayTwoBinding4 = this$0.get_binding();
                    double parseDouble = Double.parseDouble(String.valueOf((dialogGatewayTwoBinding4 == null || (editText3 = dialogGatewayTwoBinding4.start) == null) ? null : editText3.getText()));
                    DialogGatewayTwoBinding dialogGatewayTwoBinding5 = this$0.get_binding();
                    double parseDouble2 = Double.parseDouble(String.valueOf((dialogGatewayTwoBinding5 == null || (editText2 = dialogGatewayTwoBinding5.end) == null) ? null : editText2.getText()));
                    DialogGatewayTwoBinding dialogGatewayTwoBinding6 = this$0.get_binding();
                    if (dialogGatewayTwoBinding6 != null && (editText = dialogGatewayTwoBinding6.noOfEntries) != null) {
                        editable = editText.getText();
                    }
                    Map<String, List<Double>> distributeUniqueNumbers = this$0.distributeUniqueNumbers(parseDouble, parseDouble2, Integer.parseInt(String.valueOf(editable)));
                    Context requireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    this$0.generatePdf(requireContext, distributeUniqueNumbers);
                    return;
                }
            }
        }
        DialogGatewayTwoBinding dialogGatewayTwoBinding7 = this$0.get_binding();
        if (dialogGatewayTwoBinding7 == null || (textView = dialogGatewayTwoBinding7.generateBtn) == null) {
            return;
        }
        ToastExtKt.showErrorToast(textView, "All fields are required");
    }

    public final Map<String, List<Double>> distributeUniqueNumbers(double start, double end, int countPerAccount) {
        int i;
        ArrayList arrayList = new ArrayList();
        while (true) {
            i = 0;
            if (start > end) {
                break;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(start)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            arrayList.add(Double.valueOf(Double.parseDouble(format)));
            start += 0.01d;
        }
        int size = arrayList.size() / countPerAccount;
        if (size == 0) {
            throw new IllegalArgumentException("Not enough unique numbers available. Increase the range or reduce count per account.");
        }
        Collections.shuffle(arrayList);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (i < size) {
            int i2 = i * countPerAccount;
            i++;
            linkedHashMap.put("Account " + i, arrayList.subList(i2, i2 + countPerAccount));
        }
        return linkedHashMap;
    }

    public final void generatePdf(Context context, Map<String, ? extends List<Double>> accountData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountData, "accountData");
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "Distributed_Numbers.pdf");
        try {
            Document document = new Document(new PdfDocument(new PdfWriter(new FileOutputStream(file))));
            document.add((IBlockElement) new Paragraph("Distributed Unique Numbers Report\n\n"));
            for (Map.Entry<String, ? extends List<Double>> entry : accountData.entrySet()) {
                document.add((IBlockElement) new Paragraph(entry.getKey() + ": " + CollectionsKt.joinToString$default(entry.getValue(), ", ", null, null, 0, null, null, 62, null) + IOUtils.LINE_SEPARATOR_UNIX));
            }
            document.close();
            System.out.println((Object) ("✅ PDF Generated: " + file.getAbsolutePath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}