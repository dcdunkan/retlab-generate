package in.etuwa.app.ui.feepartial.hostel.edit;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.hostel.partial.admission.HostelPartialAdmission;
import in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment;
import in.etuwa.app.databinding.DialogHostelPartialEditBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: HostelPartialEditDialog.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 I2\u00020\u00012\u00020\u0002:\u0002IJB\u0005¢\u0006\u0002\u0010\u0003J\b\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00106\u001a\u000204H\u0014J\u0012\u00107\u001a\u0002042\b\u00108\u001a\u0004\u0018\u000109H\u0016J&\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010@\u001a\u000204H\u0016J\b\u0010A\u001a\u000204H\u0016J\u001a\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u000109H\u0016J\u000e\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u000204H\u0014J\b\u0010H\u001a\u000204H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0010j\b\u0012\u0004\u0012\u00020\u0018`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u0010\n\u0002\u0010,\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001a\u00100\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogHostelPartialEditBinding;", "adapter", "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter;", "getAdapter", "()Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogHostelPartialEditBinding;", "fee", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "Lkotlin/collections/ArrayList;", "getFee", "()Ljava/util/ArrayList;", "setFee", "(Ljava/util/ArrayList;)V", "hostel", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialPayment;", "hostelPartialEditViewModel", "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditViewModel;", "getHostelPartialEditViewModel", "()Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditViewModel;", "hostelPartialEditViewModel$delegate", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog$FeeDetailListner;", "month", "", "getMonth", "()Ljava/lang/String;", "setMonth", "(Ljava/lang/String;)V", "pos", "", "getPos", "()Ljava/lang/Integer;", "setPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "type", "getType", "setType", "year", "getYear", "setYear", "calculateTotal", "", "editClicked", "hideProgress", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack3", "context", "Lin/etuwa/app/ui/feepartial/hostel/HostelPartialPayment;", "setUp", "showProgress", "Companion", "FeeDetailListner", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HostelPartialEditDialog extends BaseDialog implements HostelPartialEditAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogHostelPartialEditBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<HostelPartialAdmission> fee;
    private ArrayList<HostelPartialPayment> hostel;

    /* renamed from: hostelPartialEditViewModel$delegate, reason: from kotlin metadata */
    private final Lazy hostelPartialEditViewModel;
    private FeeDetailListner listener;
    private String month;
    private Integer pos;
    private Integer type;
    private String year;

    /* compiled from: HostelPartialEditDialog.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog$FeeDetailListner;", "", "dismiss", "", "fee", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "Lkotlin/collections/ArrayList;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface FeeDetailListner {
        void dismiss(ArrayList<HostelPartialAdmission> fee, int position);
    }

    @JvmStatic
    public static final HostelPartialEditDialog newInstance(ArrayList<HostelPartialAdmission> arrayList, int i) {
        return INSTANCE.newInstance(arrayList, i);
    }

    @Override // in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter.CallBack
    public void calculateTotal() {
    }

    @Override // in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter.CallBack
    public void editClicked() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public HostelPartialEditDialog() {
        final HostelPartialEditDialog hostelPartialEditDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(hostelPartialEditDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.hostelPartialEditViewModel = FragmentViewModelLazyKt.createViewModelLazy(hostelPartialEditDialog, Reflection.getOrCreateKotlinClass(HostelPartialEditViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(HostelPartialEditViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final HostelPartialEditDialog hostelPartialEditDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HostelPartialEditAdapter>() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final HostelPartialEditAdapter invoke() {
                ComponentCallbacks componentCallbacks = hostelPartialEditDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(HostelPartialEditAdapter.class), b2, b3);
            }
        });
        this.hostel = new ArrayList<>();
        this.month = "";
        this.year = "";
        this.fee = new ArrayList<>();
    }

    private final HostelPartialEditViewModel getHostelPartialEditViewModel() {
        return (HostelPartialEditViewModel) this.hostelPartialEditViewModel.getValue();
    }

    private final HostelPartialEditAdapter getAdapter() {
        return (HostelPartialEditAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final DialogHostelPartialEditBinding get_binding() {
        return this._binding;
    }

    public final String getMonth() {
        return this.month;
    }

    public final void setMonth(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.month = str;
    }

    public final String getYear() {
        return this.year;
    }

    public final void setYear(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.year = str;
    }

    public final ArrayList<HostelPartialAdmission> getFee() {
        return this.fee;
    }

    public final void setFee(ArrayList<HostelPartialAdmission> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.fee = arrayList;
    }

    public final Integer getPos() {
        return this.pos;
    }

    public final void setPos(Integer num) {
        this.pos = num;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    /* compiled from: HostelPartialEditDialog.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/feepartial/hostel/edit/HostelPartialEditDialog;", "fee", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/hostel/partial/admission/HostelPartialAdmission;", "Lkotlin/collections/ArrayList;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostelPartialEditDialog newInstance(ArrayList<HostelPartialAdmission> fee, int position) {
            Intrinsics.checkNotNullParameter(fee, "fee");
            HostelPartialEditDialog hostelPartialEditDialog = new HostelPartialEditDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            hostelPartialEditDialog.setArguments(bundle);
            return hostelPartialEditDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.pos = Integer.valueOf(arguments.getInt("type"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogHostelPartialEditBinding.inflate(inflater, container, false);
        DialogHostelPartialEditBinding dialogHostelPartialEditBinding = get_binding();
        if (dialogHostelPartialEditBinding != null) {
            dialogHostelPartialEditBinding.setHostelPartialEditViewModel(getHostelPartialEditViewModel());
        }
        DialogHostelPartialEditBinding dialogHostelPartialEditBinding2 = get_binding();
        if (dialogHostelPartialEditBinding2 != null) {
            dialogHostelPartialEditBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogHostelPartialEditBinding dialogHostelPartialEditBinding3 = get_binding();
        if (dialogHostelPartialEditBinding3 != null) {
            return dialogHostelPartialEditBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("Pay Confirmation");
        }
        System.out.println((Object) "=====================");
        System.out.println(this.pos);
        DialogHostelPartialEditBinding dialogHostelPartialEditBinding = get_binding();
        RecyclerView recyclerView = dialogHostelPartialEditBinding != null ? dialogHostelPartialEditBinding.rvHostelFee : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        HostelPartialEditAdapter adapter = getAdapter();
        ArrayList<HostelPartialAdmission> arrayList = this.fee;
        Integer num = this.pos;
        Intrinsics.checkNotNull(num);
        adapter.addItems(arrayList.get(num.intValue()).getPayment());
        ArrayList<HostelPartialAdmission> arrayList2 = this.fee;
        Integer num2 = this.pos;
        Intrinsics.checkNotNull(num2);
        System.out.println(arrayList2.get(num2.intValue()).getPayment());
        DialogHostelPartialEditBinding dialogHostelPartialEditBinding2 = get_binding();
        if (dialogHostelPartialEditBinding2 == null || (textView = dialogHostelPartialEditBinding2.confirmBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.feepartial.hostel.edit.HostelPartialEditDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HostelPartialEditDialog.setUp$lambda$1(HostelPartialEditDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(HostelPartialEditDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<HostelPartialPayment> items = this$0.getAdapter().getItems();
        Intrinsics.checkNotNull(items, "null cannot be cast to non-null type java.util.ArrayList<in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment>{ kotlin.collections.TypeAliasesKt.ArrayList<in.etuwa.app.data.model.hostel.partial.admission.HostelPartialPayment> }");
        this$0.hostel = (ArrayList) items;
        ArrayList<HostelPartialAdmission> arrayList = this$0.fee;
        Integer num = this$0.pos;
        Intrinsics.checkNotNull(num);
        arrayList.get(num.intValue()).setPayment(this$0.hostel);
        System.out.println((Object) ("feeees " + this$0.fee));
        FeeDetailListner feeDetailListner = this$0.listener;
        if (feeDetailListner != null) {
            ArrayList<HostelPartialAdmission> arrayList2 = this$0.fee;
            Integer num2 = this$0.pos;
            Intrinsics.checkNotNull(num2);
            feeDetailListner.dismiss(arrayList2, num2.intValue());
        }
        this$0.dismiss();
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

    public final void setCallBack3(in.etuwa.app.ui.feepartial.hostel.HostelPartialPayment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }
}