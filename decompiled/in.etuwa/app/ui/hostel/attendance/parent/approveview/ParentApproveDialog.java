package in.etuwa.app.ui.hostel.attendance.parent.approveview;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.messaging.Constants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.hostel.attendance.HostelAttParentView;
import in.etuwa.app.data.model.hostel.attendance.HostelDates;
import in.etuwa.app.databinding.DialogParentApproveBinding;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: ParentApproveDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class ParentApproveDialog extends BottomSheetDialogFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "ParentApproveDialog";
    private DialogParentApproveBinding _binding;
    private LeaveDateAdapter dateAdapter;
    private HostelAttParentView leaveData;
    private Function1<? super List<LeaveDateState>, Unit> onApproveListener;
    private Function0<Unit> onRejectListener;

    /* JADX INFO: renamed from: parentApproveViewModel$delegate, reason: from kotlin metadata */
    private final Lazy parentApproveViewModel;

    /* JADX INFO: compiled from: ParentApproveDialog.kt */
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

    public ParentApproveDialog() {
        final ParentApproveDialog parentApproveDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return parentApproveDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(parentApproveDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.parentApproveViewModel = FragmentViewModelLazyKt.createViewModelLazy(parentApproveDialog, Reflection.getOrCreateKotlinClass(ParentApproveViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(ParentApproveViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final DialogParentApproveBinding getBinding() {
        DialogParentApproveBinding dialogParentApproveBinding = this._binding;
        Intrinsics.checkNotNull(dialogParentApproveBinding);
        return dialogParentApproveBinding;
    }

    private final ParentApproveViewModel getParentApproveViewModel() {
        return (ParentApproveViewModel) this.parentApproveViewModel.getValue();
    }

    /* JADX INFO: compiled from: ParentApproveDialog.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/hostel/attendance/parent/approveview/ParentApproveDialog$Companion;", "", "()V", "TAG", "", "newInstance", "Lin/etuwa/app/ui/hostel/attendance/parent/approveview/ParentApproveDialog;", Constants.ScionAnalytics.MessageType.DATA_MESSAGE, "Lin/etuwa/app/data/model/hostel/attendance/HostelAttParentView;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ParentApproveDialog newInstance(HostelAttParentView data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ParentApproveDialog parentApproveDialog = new ParentApproveDialog();
            parentApproveDialog.setLeaveData(data);
            return parentApproveDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        View viewFindViewById;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (viewFindViewById = dialog.findViewById(R.id.design_bottom_sheet)) == null) {
            return;
        }
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(viewFindViewById);
        Intrinsics.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "from(it)");
        bottomSheetBehaviorFrom.setState(3);
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setDraggable(true);
        bottomSheetBehaviorFrom.setPeekHeight(-1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogParentApproveBinding.inflate(inflater, container, false);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setupUI();
        setupRecyclerView();
        setupClickListeners();
    }

    private final void setupUI() {
        listenApproveResponse();
        HostelAttParentView hostelAttParentView = this.leaveData;
        if (hostelAttParentView != null) {
            getBinding().tvLeaveType.setText(hostelAttParentView.getType());
            getBinding().tvReason.setText(hostelAttParentView.getReason());
        }
    }

    private final void setupRecyclerView() {
        ArrayList arrayListEmptyList;
        ArrayList<HostelDates> dates;
        HostelAttParentView hostelAttParentView = this.leaveData;
        if (hostelAttParentView == null || (dates = hostelAttParentView.getDates()) == null) {
            arrayListEmptyList = CollectionsKt.emptyList();
        } else {
            ArrayList<HostelDates> arrayList = dates;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
            for (HostelDates hostelDates : arrayList) {
                arrayList2.add(new LeaveDateItem(hostelDates.getId(), hostelDates.getDate()));
            }
            arrayListEmptyList = arrayList2;
        }
        Log.d("RV_DEBUG", "Dates size = " + arrayListEmptyList.size());
        this.dateAdapter = new LeaveDateAdapter(arrayListEmptyList, new Function0<Unit>() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog.setupRecyclerView.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ParentApproveDialog.this.updateSelectAllCheckbox();
            }
        });
        getBinding().rvDates.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView = getBinding().rvDates;
        LeaveDateAdapter leaveDateAdapter = this.dateAdapter;
        if (leaveDateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
            leaveDateAdapter = null;
        }
        recyclerView.setAdapter(leaveDateAdapter);
    }

    private final void setupClickListeners() {
        final HashMap map = new HashMap();
        getBinding().checkboxSelectAll.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$$ExternalSyntheticLambda2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                ParentApproveDialog.setupClickListeners$lambda$3(this.f$0, compoundButton, z);
            }
        });
        getBinding().btnApprove.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ParentApproveDialog.setupClickListeners$lambda$4(this.f$0, map, view);
            }
        });
        getBinding().btnReject.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ParentApproveDialog.setupClickListeners$lambda$5(this.f$0, map, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$3(ParentApproveDialog this$0, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(compoundButton, "<anonymous parameter 0>");
        LeaveDateAdapter leaveDateAdapter = this$0.dateAdapter;
        if (leaveDateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
            leaveDateAdapter = null;
        }
        leaveDateAdapter.selectAll(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$4(ParentApproveDialog this$0, HashMap approveRejectCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(approveRejectCollection, "$approveRejectCollection");
        Function1<? super List<LeaveDateState>, Unit> function1 = this$0.onApproveListener;
        LeaveDateAdapter leaveDateAdapter = null;
        if (function1 != null) {
            LeaveDateAdapter leaveDateAdapter2 = this$0.dateAdapter;
            if (leaveDateAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
                leaveDateAdapter2 = null;
            }
            function1.invoke(leaveDateAdapter2.getDateStates());
        }
        approveRejectCollection.clear();
        LeaveDateAdapter leaveDateAdapter3 = this$0.dateAdapter;
        if (leaveDateAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
        } else {
            leaveDateAdapter = leaveDateAdapter3;
        }
        List<LeaveDateState> dateStates = leaveDateAdapter.getDateStates();
        System.out.println(dateStates);
        int size = dateStates.size();
        for (int i = 0; i < size; i++) {
            if (dateStates.get(i).isChecked()) {
                approveRejectCollection.put("ParentApproveByDate[datesApproved][" + dateStates.get(i).getId() + "]", dateStates.get(i).getId());
            } else {
                approveRejectCollection.put("ParentApproveByDate[datesRejected][" + dateStates.get(i).getId() + "]", dateStates.get(i).getId());
            }
        }
        this$0.getParentApproveViewModel().getApproveResponse(approveRejectCollection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupClickListeners$lambda$5(ParentApproveDialog this$0, HashMap approveRejectCollection, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(approveRejectCollection, "$approveRejectCollection");
        Function0<Unit> function0 = this$0.onRejectListener;
        if (function0 != null) {
            function0.invoke();
        }
        approveRejectCollection.clear();
        LeaveDateAdapter leaveDateAdapter = this$0.dateAdapter;
        if (leaveDateAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dateAdapter");
            leaveDateAdapter = null;
        }
        List<LeaveDateState> dateStates = leaveDateAdapter.getDateStates();
        System.out.println(dateStates);
        int size = dateStates.size();
        for (int i = 0; i < size; i++) {
            if (dateStates.get(i).isChecked()) {
                approveRejectCollection.put("ParentApproveByDate[datesRejected][" + dateStates.get(i).getId() + "]", dateStates.get(i).getId());
            } else {
                approveRejectCollection.put("ParentApproveByDate[datesApproved][" + dateStates.get(i).getId() + "]", dateStates.get(i).getId());
            }
        }
        this$0.getParentApproveViewModel().getApproveResponse(approveRejectCollection);
    }

    private final void listenApproveResponse() {
        getParentApproveViewModel().getApproveResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ParentApproveDialog.listenApproveResponse$lambda$7(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenApproveResponse$lambda$7(ParentApproveDialog this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i != 4) {
                return;
            }
            RecyclerView recyclerView = this$0.getBinding().rvDates;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDates");
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getLogin()) {
                RecyclerView recyclerView2 = this$0.getBinding().rvDates;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDates");
                ToastExtKt.showSuccessToast(recyclerView2, successResponse.getMessage());
            } else {
                RecyclerView recyclerView3 = this$0.getBinding().rvDates;
                Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.rvDates");
                ToastExtKt.showErrorToast(recyclerView3, "netwok error");
            }
        }
    }

    private final void listenRejectResponse() {
        getParentApproveViewModel().getRejectResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ParentApproveDialog.listenRejectResponse$lambda$9(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenRejectResponse$lambda$9(ParentApproveDialog this$0, Resource resource) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i != 4) {
                return;
            }
            RecyclerView recyclerView = this$0.getBinding().rvDates;
            Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.rvDates");
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            if (successResponse.getLogin()) {
                RecyclerView recyclerView2 = this$0.getBinding().rvDates;
                Intrinsics.checkNotNullExpressionValue(recyclerView2, "binding.rvDates");
                ToastExtKt.showSuccessToast(recyclerView2, successResponse.getMessage());
            } else {
                RecyclerView recyclerView3 = this$0.getBinding().rvDates;
                Intrinsics.checkNotNullExpressionValue(recyclerView3, "binding.rvDates");
                ToastExtKt.showErrorToast(recyclerView3, "netwok error");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void updateSelectAllCheckbox() {
        /*
            r5 = this;
            in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateAdapter r0 = r5.dateAdapter
            if (r0 != 0) goto La
            java.lang.String r0 = "dateAdapter"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = 0
        La:
            java.util.List r0 = r0.getDateStates()
            in.etuwa.app.databinding.DialogParentApproveBinding r1 = r5.getBinding()
            com.google.android.material.checkbox.MaterialCheckBox r1 = r1.checkboxSelectAll
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r3 = 1
            r2 = r2 ^ r3
            r4 = 0
            if (r2 == 0) goto L4b
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r2 = r0 instanceof java.util.Collection
            if (r2 == 0) goto L31
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L31
        L2f:
            r0 = 1
            goto L48
        L31:
            java.util.Iterator r0 = r0.iterator()
        L35:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2f
            java.lang.Object r2 = r0.next()
            in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateState r2 = (in.etuwa.app.ui.hostel.attendance.parent.approveview.LeaveDateState) r2
            boolean r2 = r2.isChecked()
            if (r2 != 0) goto L35
            r0 = 0
        L48:
            if (r0 == 0) goto L4b
            goto L4c
        L4b:
            r3 = 0
        L4c:
            r1.setChecked(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.hostel.attendance.parent.approveview.ParentApproveDialog.updateSelectAllCheckbox():void");
    }

    public final void setLeaveData(HostelAttParentView data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.leaveData = data;
    }

    public final void setOnApproveListener(Function1<? super List<LeaveDateState>, Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onApproveListener = listener;
    }

    public final void setOnRejectListener(Function0<Unit> listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onRejectListener = listener;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }
}