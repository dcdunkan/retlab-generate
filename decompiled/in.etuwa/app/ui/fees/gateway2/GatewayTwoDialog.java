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

/* JADX INFO: compiled from: GatewayTwoDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GatewayTwoDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogGatewayTwoBinding _binding;

    /* JADX INFO: renamed from: gatewayTwoViewModel$delegate, reason: from kotlin metadata */
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
                return gatewayTwoDialog;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) function0.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(GatewayTwoViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final GatewayTwoViewModel getGatewayTwoViewModel() {
        return (GatewayTwoViewModel) this.gatewayTwoViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final DialogGatewayTwoBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: GatewayTwoDialog.kt */
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
                GatewayTwoDialog.setUp$lambda$1(this.f$0, view);
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
        Editable text2 = null;
        if (!Intrinsics.areEqual(String.valueOf((dialogGatewayTwoBinding == null || (editText6 = dialogGatewayTwoBinding.start) == null) ? null : editText6.getText()), "")) {
            DialogGatewayTwoBinding dialogGatewayTwoBinding2 = this$0.get_binding();
            if (!Intrinsics.areEqual((dialogGatewayTwoBinding2 == null || (editText5 = dialogGatewayTwoBinding2.end) == null || (text = editText5.getText()) == null) ? null : text.toString(), "")) {
                DialogGatewayTwoBinding dialogGatewayTwoBinding3 = this$0.get_binding();
                if (!Intrinsics.areEqual(String.valueOf((dialogGatewayTwoBinding3 == null || (editText4 = dialogGatewayTwoBinding3.noOfEntries) == null) ? null : editText4.getText()), "")) {
                    DialogGatewayTwoBinding dialogGatewayTwoBinding4 = this$0.get_binding();
                    double d = Double.parseDouble(String.valueOf((dialogGatewayTwoBinding4 == null || (editText3 = dialogGatewayTwoBinding4.start) == null) ? null : editText3.getText()));
                    DialogGatewayTwoBinding dialogGatewayTwoBinding5 = this$0.get_binding();
                    double d2 = Double.parseDouble(String.valueOf((dialogGatewayTwoBinding5 == null || (editText2 = dialogGatewayTwoBinding5.end) == null) ? null : editText2.getText()));
                    DialogGatewayTwoBinding dialogGatewayTwoBinding6 = this$0.get_binding();
                    if (dialogGatewayTwoBinding6 != null && (editText = dialogGatewayTwoBinding6.noOfEntries) != null) {
                        text2 = editText.getText();
                    }
                    Map<String, List<Double>> mapDistributeUniqueNumbers = this$0.distributeUniqueNumbers(d, d2, Integer.parseInt(String.valueOf(text2)));
                    Context contextRequireContext = this$0.requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    this$0.generatePdf(contextRequireContext, mapDistributeUniqueNumbers);
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
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Double.valueOf(start)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            arrayList.add(Double.valueOf(Double.parseDouble(str)));
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