package in.etuwa.app.ui.stationary.booking.orderpage;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.stationary.AdvancePaymentResponse;
import in.etuwa.app.data.model.stationary.StationaryItem;
import in.etuwa.app.data.model.stationary.StationaryItemResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.DialogStationaryPayBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.feenewengineer.payment.feeconfirmdialog.FeeConfirmDialogKt;
import in.etuwa.app.ui.stationary.booking.BookingFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
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

/* JADX INFO: compiled from: OrderPageDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class OrderPageDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogStationaryPayBinding _binding;
    private String id;
    private StationaryListener listener;
    private MainCallBackListener listener2;

    /* JADX INFO: renamed from: orderPageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy orderPageViewModel;
    private Integer position;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private Double total;
    private Double unitPrice;

    /* JADX INFO: compiled from: OrderPageDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/stationary/booking/orderpage/OrderPageDialog$StationaryListener;", "", "dismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface StationaryListener {
        void dismiss();
    }

    /* JADX INFO: compiled from: OrderPageDialog.kt */
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
    public static final OrderPageDialog newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public OrderPageDialog() {
        final OrderPageDialog orderPageDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return orderPageDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(orderPageDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.orderPageViewModel = FragmentViewModelLazyKt.createViewModelLazy(orderPageDialog, Reflection.getOrCreateKotlinClass(OrderPageViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(OrderPageViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final OrderPageDialog orderPageDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = orderPageDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b2, b3);
            }
        });
    }

    private final OrderPageViewModel getOrderPageViewModel() {
        return (OrderPageViewModel) this.orderPageViewModel.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final DialogStationaryPayBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: OrderPageDialog.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/stationary/booking/orderpage/OrderPageDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/stationary/booking/orderpage/OrderPageDialog;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final OrderPageDialog newInstance(int position) {
            OrderPageDialog orderPageDialog = new OrderPageDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            orderPageDialog.setArguments(bundle);
            return orderPageDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = Integer.valueOf(arguments.getInt("type"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogStationaryPayBinding.inflate(inflater, container, false);
        DialogStationaryPayBinding dialogStationaryPayBinding = get_binding();
        if (dialogStationaryPayBinding != null) {
            dialogStationaryPayBinding.setOrderPageViewModel(getOrderPageViewModel());
        }
        DialogStationaryPayBinding dialogStationaryPayBinding2 = get_binding();
        if (dialogStationaryPayBinding2 != null) {
            dialogStationaryPayBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogStationaryPayBinding dialogStationaryPayBinding3 = get_binding();
        if (dialogStationaryPayBinding3 != null) {
            return dialogStationaryPayBinding3.getRoot();
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
        ImageView imageView;
        ImageView imageView2;
        getPreference().setNewLogin(false);
        listenResponse();
        listenUrlResponse();
        getOrderPageViewModel().getStationaryList();
        DialogStationaryPayBinding dialogStationaryPayBinding = get_binding();
        if (dialogStationaryPayBinding != null && (imageView2 = dialogStationaryPayBinding.addBtn) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderPageDialog.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        DialogStationaryPayBinding dialogStationaryPayBinding2 = get_binding();
        if (dialogStationaryPayBinding2 != null && (imageView = dialogStationaryPayBinding2.removeBtn) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OrderPageDialog.setUp$lambda$2(this.f$0, view);
                }
            });
        }
        DialogStationaryPayBinding dialogStationaryPayBinding3 = get_binding();
        if (dialogStationaryPayBinding3 == null || (textView = dialogStationaryPayBinding3.payBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderPageDialog.setUp$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(OrderPageDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogStationaryPayBinding dialogStationaryPayBinding = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogStationaryPayBinding == null || (editText3 = dialogStationaryPayBinding.etQuantity) == null) ? null : editText3.getText()), "1")) {
            DialogStationaryPayBinding dialogStationaryPayBinding2 = this$0.get_binding();
            ImageView imageView = dialogStationaryPayBinding2 != null ? dialogStationaryPayBinding2.removeBtn : null;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        }
        DialogStationaryPayBinding dialogStationaryPayBinding3 = this$0.get_binding();
        int i = Integer.parseInt(String.valueOf((dialogStationaryPayBinding3 == null || (editText2 = dialogStationaryPayBinding3.etQuantity) == null) ? null : editText2.getText())) + 1;
        DialogStationaryPayBinding dialogStationaryPayBinding4 = this$0.get_binding();
        if (dialogStationaryPayBinding4 != null && (editText = dialogStationaryPayBinding4.etQuantity) != null) {
            editText.setText(String.valueOf(i));
        }
        Double d = this$0.unitPrice;
        Intrinsics.checkNotNull(d);
        double dDoubleValue = d.doubleValue() * ((double) i);
        DialogStationaryPayBinding dialogStationaryPayBinding5 = this$0.get_binding();
        TextView textView = dialogStationaryPayBinding5 != null ? dialogStationaryPayBinding5.tvTotalPrice : null;
        if (textView != null) {
            textView.setText(String.valueOf(dDoubleValue));
        }
        this$0.total = Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(OrderPageDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        DialogStationaryPayBinding dialogStationaryPayBinding = this$0.get_binding();
        if (Intrinsics.areEqual(String.valueOf((dialogStationaryPayBinding == null || (editText3 = dialogStationaryPayBinding.etQuantity) == null) ? null : editText3.getText()), ExifInterface.GPS_MEASUREMENT_2D)) {
            DialogStationaryPayBinding dialogStationaryPayBinding2 = this$0.get_binding();
            ImageView imageView = dialogStationaryPayBinding2 != null ? dialogStationaryPayBinding2.removeBtn : null;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        }
        DialogStationaryPayBinding dialogStationaryPayBinding3 = this$0.get_binding();
        int i = Integer.parseInt(String.valueOf((dialogStationaryPayBinding3 == null || (editText2 = dialogStationaryPayBinding3.etQuantity) == null) ? null : editText2.getText())) - 1;
        DialogStationaryPayBinding dialogStationaryPayBinding4 = this$0.get_binding();
        if (dialogStationaryPayBinding4 != null && (editText = dialogStationaryPayBinding4.etQuantity) != null) {
            editText.setText(String.valueOf(i));
        }
        Double d = this$0.unitPrice;
        Intrinsics.checkNotNull(d);
        double dDoubleValue = d.doubleValue() * ((double) i);
        DialogStationaryPayBinding dialogStationaryPayBinding5 = this$0.get_binding();
        TextView textView = dialogStationaryPayBinding5 != null ? dialogStationaryPayBinding5.tvTotalPrice : null;
        if (textView != null) {
            textView.setText(String.valueOf(dDoubleValue));
        }
        this$0.total = Double.valueOf(dDoubleValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(OrderPageDialog this$0, View view) {
        TextView textView;
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HashMap map = new HashMap();
        map.put("pay", "1");
        String str = this$0.id;
        Intrinsics.checkNotNull(str);
        map.put("InventoryAdvanceBookingCollections[product_id]", str);
        DialogStationaryPayBinding dialogStationaryPayBinding = this$0.get_binding();
        CharSequence text = null;
        map.put("InventoryAdvanceBookingCollections[quantity]", String.valueOf((dialogStationaryPayBinding == null || (editText = dialogStationaryPayBinding.etQuantity) == null) ? null : editText.getText()));
        Double d = this$0.unitPrice;
        Intrinsics.checkNotNull(d);
        map.put("InventoryAdvanceBookingCollections[unit_price]", String.valueOf(d.doubleValue()));
        DialogStationaryPayBinding dialogStationaryPayBinding2 = this$0.get_binding();
        if (dialogStationaryPayBinding2 != null && (textView = dialogStationaryPayBinding2.tvTotalPrice) != null) {
            text = textView.getText();
        }
        map.put("InventoryAdvanceBookingCollections[total_price]", String.valueOf(text));
        Double d2 = this$0.unitPrice;
        Intrinsics.checkNotNull(d2);
        System.out.println(d2.doubleValue());
        System.out.println(this$0.total);
        this$0.getOrderPageViewModel().getAdvancePaymentUrl(map);
    }

    private final void listenResponse() {
        getOrderPageViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPageDialog.listenResponse$lambda$5(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(OrderPageDialog this$0, Resource resource) {
        EditText editText;
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
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
            DialogStationaryPayBinding dialogStationaryPayBinding = this$0.get_binding();
            if (dialogStationaryPayBinding == null || (textView = dialogStationaryPayBinding.payBtn) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(textView, message);
            return;
        }
        this$0.hideProgress();
        StationaryItemResponse stationaryItemResponse = (StationaryItemResponse) resource.getData();
        if (stationaryItemResponse != null) {
            DialogStationaryPayBinding dialogStationaryPayBinding2 = this$0.get_binding();
            TextView textView2 = dialogStationaryPayBinding2 != null ? dialogStationaryPayBinding2.tvProductName : null;
            if (textView2 != null) {
                ArrayList<StationaryItem> data = stationaryItemResponse.getData();
                Integer num = this$0.position;
                Intrinsics.checkNotNull(num);
                textView2.setText(data.get(num.intValue()).getName());
            }
            DialogStationaryPayBinding dialogStationaryPayBinding3 = this$0.get_binding();
            TextView textView3 = dialogStationaryPayBinding3 != null ? dialogStationaryPayBinding3.tvUnitPrice : null;
            if (textView3 != null) {
                ArrayList<StationaryItem> data2 = stationaryItemResponse.getData();
                Integer num2 = this$0.position;
                Intrinsics.checkNotNull(num2);
                textView3.setText(data2.get(num2.intValue()).getPrice());
            }
            DialogStationaryPayBinding dialogStationaryPayBinding4 = this$0.get_binding();
            if (dialogStationaryPayBinding4 != null && (editText = dialogStationaryPayBinding4.etQuantity) != null) {
                editText.setText("1");
            }
            DialogStationaryPayBinding dialogStationaryPayBinding5 = this$0.get_binding();
            TextView textView4 = dialogStationaryPayBinding5 != null ? dialogStationaryPayBinding5.tvTotalPrice : null;
            if (textView4 != null) {
                ArrayList<StationaryItem> data3 = stationaryItemResponse.getData();
                Integer num3 = this$0.position;
                Intrinsics.checkNotNull(num3);
                textView4.setText(data3.get(num3.intValue()).getPrice());
            }
            ArrayList<StationaryItem> data4 = stationaryItemResponse.getData();
            Integer num4 = this$0.position;
            Intrinsics.checkNotNull(num4);
            this$0.unitPrice = Double.valueOf(Double.parseDouble(data4.get(num4.intValue()).getPrice()));
            ArrayList<StationaryItem> data5 = stationaryItemResponse.getData();
            Integer num5 = this$0.position;
            Intrinsics.checkNotNull(num5);
            this$0.id = data5.get(num5.intValue()).getId();
        }
    }

    private final void listenUrlResponse() {
        getOrderPageViewModel().getUrlResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.stationary.booking.orderpage.OrderPageDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OrderPageDialog.listenUrlResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenUrlResponse$lambda$7(OrderPageDialog this$0, Resource resource) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            AdvancePaymentResponse advancePaymentResponse = (AdvancePaymentResponse) resource.getData();
            if (advancePaymentResponse != null) {
                System.out.println((Object) advancePaymentResponse.getUrl());
                MainCallBackListener mainCallBackListener = this$0.listener2;
                if (mainCallBackListener != null) {
                    mainCallBackListener.openPaymentPage(advancePaymentResponse.getUrl());
                    return;
                }
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
        DialogStationaryPayBinding dialogStationaryPayBinding = this$0.get_binding();
        if (dialogStationaryPayBinding == null || (textView = dialogStationaryPayBinding.payBtn) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(textView, message);
    }

    public final void setCallBack(BookingFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        StationaryListener stationaryListener = this.listener;
        if (stationaryListener != null) {
            stationaryListener.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listener2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }
}