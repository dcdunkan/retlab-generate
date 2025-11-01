package in.etuwa.app.ui.assignment;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.assignment.AssignmentResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.AssignmentFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.assignment.AssignmentAdapter;
import in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo;
import in.etuwa.app.utils.AppConstant;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: AssignmentFragment.kt */
@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 ]2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001]B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0017H\u0016J \u00104\u001a\u0002022\u0006\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u0002072\u0006\u0010\u001c\u001a\u00020\u001dH\u0017J\b\u00108\u001a\u000202H\u0014J\b\u00109\u001a\u000202H\u0014J\b\u0010:\u001a\u000202H\u0002J\b\u0010;\u001a\u000202H\u0002J\b\u0010<\u001a\u000202H\u0002J\u0010\u0010=\u001a\u0002022\u0006\u00103\u001a\u00020\u0017H\u0002J\u0018\u0010>\u001a\u0002022\u0006\u00103\u001a\u00020\u00172\u0006\u0010?\u001a\u00020\u0017H\u0016J\u0018\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010C\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000202H\u0016J\b\u0010M\u001a\u000202H\u0016J\b\u0010N\u001a\u000202H\u0016J\u0010\u0010O\u001a\u0002022\u0006\u00103\u001a\u00020\u0017H\u0016J-\u0010P\u001a\u0002022\u0006\u0010Q\u001a\u0002072\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170S2\u0006\u0010T\u001a\u00020UH\u0016¢\u0006\u0002\u0010VJ\u001a\u0010W\u001a\u0002022\u0006\u0010X\u001a\u00020F2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010Y\u001a\u000202H\u0002J\b\u0010Z\u001a\u000202H\u0014J\b\u0010[\u001a\u000202H\u0014J\b\u0010\\\u001a\u000202H\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\u0019j\b\u0012\u0004\u0012\u00020\u001a`\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\r\u001a\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u0010*\u001a\u00020+8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\r\u001a\u0004\b,\u0010-¨\u0006^"}, d2 = {"Lin/etuwa/app/ui/assignment/AssignmentFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/assignment/AssignmentAdapter$AssignmentListener;", "Lin/etuwa/app/ui/assignment/upload/UploadAssignmentDialog$UploadAssignmentCallBack;", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/AssignmentFragmentBinding;", "adapter", "Lin/etuwa/app/ui/assignment/AssignmentAdapter;", "getAdapter", "()Lin/etuwa/app/ui/assignment/AssignmentAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "assignmentViewModel", "Lin/etuwa/app/ui/assignment/AssignmentViewModel;", "getAssignmentViewModel", "()Lin/etuwa/app/ui/assignment/AssignmentViewModel;", "assignmentViewModel$delegate", "binding", "getBinding", "()Lin/etuwa/app/databinding/AssignmentFragmentBinding;", "current", "", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "flag", "", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "getSemId", "()Ljava/lang/String;", "setSemId", "(Ljava/lang/String;)V", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "checkFileExistence", "fileName", "deleteAssignment", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "listenSemResponse", "loadPickerDialog", "loadSelectedSem", "sem", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AssignmentFragment extends BaseFragment implements AssignmentAdapter.AssignmentListener, UploadAssignmentDialog.UploadAssignmentCallBack, SemListDialogTwo.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private AssignmentFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: assignmentViewModel$delegate, reason: from kotlin metadata */
    private final Lazy assignmentViewModel;
    private String current;
    private ArrayList<DownloadModel> downList;
    private boolean flag;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: AssignmentFragment.kt */
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
    public static final AssignmentFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public AssignmentFragment() {
        final AssignmentFragment assignmentFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(assignmentFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.assignmentViewModel = FragmentViewModelLazyKt.createViewModelLazy(assignmentFragment, Reflection.getOrCreateKotlinClass(AssignmentViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(AssignmentViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final AssignmentFragment assignmentFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<AssignmentAdapter>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.assignment.AssignmentAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final AssignmentAdapter invoke() {
                ComponentCallbacks componentCallbacks = assignmentFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(AssignmentAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(AssignmentFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = assignmentFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = assignmentFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.current = "";
        this.semId = getPreference().getUserSemId();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                AssignmentAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = AssignmentFragment.this.downList;
                    AssignmentFragment assignmentFragment3 = AssignmentFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = assignmentFragment3.getAdapter();
                            arrayList2 = assignmentFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = assignmentFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssignmentViewModel getAssignmentViewModel() {
        return (AssignmentViewModel) this.assignmentViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AssignmentAdapter getAdapter() {
        return (AssignmentAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final AssignmentFragmentBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SemesterSpinnerAdapter getSpinnerAdapter() {
        return (SemesterSpinnerAdapter) this.spinnerAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final String getSemId() {
        return this.semId;
    }

    public final void setSemId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semId = str;
    }

    /* compiled from: AssignmentFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/assignment/AssignmentFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/assignment/AssignmentFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final AssignmentFragment newInstance() {
            return new AssignmentFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = AssignmentFragmentBinding.inflate(inflater, container, false);
        AssignmentFragmentBinding assignmentFragmentBinding = get_binding();
        if (assignmentFragmentBinding != null) {
            assignmentFragmentBinding.setAssignmentViewModel(getAssignmentViewModel());
        }
        AssignmentFragmentBinding assignmentFragmentBinding2 = get_binding();
        if (assignmentFragmentBinding2 != null) {
            assignmentFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        AssignmentFragmentBinding assignmentFragmentBinding3 = get_binding();
        if (assignmentFragmentBinding3 != null) {
            return assignmentFragmentBinding3.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setUp();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void setUp() {
        SwipeRefreshLayout swipeRefreshLayout;
        FloatingActionButton floatingActionButton;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        FloatingActionButton floatingActionButton2;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.assignment));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        AssignmentFragmentBinding assignmentFragmentBinding = get_binding();
        RecyclerView recyclerView = assignmentFragmentBinding != null ? assignmentFragmentBinding.rvAssignment : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setAssignmentListener(this);
        AssignmentFragmentBinding assignmentFragmentBinding2 = get_binding();
        Spinner spinner = assignmentFragmentBinding2 != null ? assignmentFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        AssignmentFragmentBinding assignmentFragmentBinding3 = get_binding();
        if (assignmentFragmentBinding3 != null && (floatingActionButton2 = assignmentFragmentBinding3.fabAssignmentSemester) != null) {
            floatingActionButton2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$0(AssignmentFragment.this, view);
                }
            });
        }
        listenSemResponse();
        getAssignmentViewModel().getAssignment("", "", this.current);
        listenResponse();
        AssignmentFragmentBinding assignmentFragmentBinding4 = get_binding();
        if (assignmentFragmentBinding4 != null && (textView3 = assignmentFragmentBinding4.filterSubmitted) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$1(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding5 = get_binding();
        if (assignmentFragmentBinding5 != null && (textView2 = assignmentFragmentBinding5.filterNotsubmited) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$2(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding6 = get_binding();
        if (assignmentFragmentBinding6 != null && (textView = assignmentFragmentBinding6.filterAll) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$3(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding7 = get_binding();
        if (assignmentFragmentBinding7 != null && (linearLayout2 = assignmentFragmentBinding7.assiFilter) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$5(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding8 = get_binding();
        if (assignmentFragmentBinding8 != null && (linearLayout = assignmentFragmentBinding8.assiSort) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$7(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding9 = get_binding();
        if (assignmentFragmentBinding9 != null && (floatingActionButton = assignmentFragmentBinding9.fabAss) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda14
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AssignmentFragment.setUp$lambda$9(AssignmentFragment.this, view);
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding10 = get_binding();
        Spinner spinner2 = assignmentFragmentBinding10 != null ? assignmentFragmentBinding10.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$setUp$8
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> parent) {
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    SemesterSpinnerAdapter spinnerAdapter;
                    boolean z;
                    SemesterSpinnerAdapter spinnerAdapter2;
                    SharedPrefManager preference;
                    SemesterSpinnerAdapter spinnerAdapter3;
                    AssignmentFragmentBinding assignmentFragmentBinding11;
                    AssignmentViewModel assignmentViewModel;
                    SharedPrefManager preference2;
                    Spinner spinner3;
                    AssignmentViewModel assignmentViewModel2;
                    spinnerAdapter = AssignmentFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = AssignmentFragment.this.flag;
                    if (z) {
                        assignmentViewModel2 = AssignmentFragment.this.getAssignmentViewModel();
                        assignmentViewModel2.getAssignment("", "", semester.getId());
                        AssignmentFragment.this.current = semester.getId();
                        return;
                    }
                    AssignmentFragment.this.flag = true;
                    spinnerAdapter2 = AssignmentFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = AssignmentFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = AssignmentFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            assignmentFragmentBinding11 = AssignmentFragment.this.get_binding();
                            if (assignmentFragmentBinding11 != null && (spinner3 = assignmentFragmentBinding11.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                assignmentViewModel = AssignmentFragment.this.getAssignmentViewModel();
                                preference2 = AssignmentFragment.this.getPreference();
                                assignmentViewModel.getAssignment("", "", preference2.getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        AssignmentFragmentBinding assignmentFragmentBinding11 = get_binding();
        if (assignmentFragmentBinding11 == null || (swipeRefreshLayout = assignmentFragmentBinding11.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda15
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                AssignmentFragment.setUp$lambda$10(AssignmentFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo newInstance = SemListDialogTwo.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAssignmentViewModel().getAssignment("SUBMITTED", "", this$0.current);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAssignmentViewModel().getAssignment("NOT SUBMITTED", "", this$0.current);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(final AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            View inflate = this$0.getLayoutInflater().inflate(R.layout.bottom_sheet_filter, (ViewGroup) null);
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.filter_group);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this$0.requireContext());
            bottomSheetDialog.setContentView(inflate);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda4
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    AssignmentFragment.setUp$lambda$5$lambda$4(AssignmentFragment.this, bottomSheetDialog, radioGroup2, i);
                }
            });
            bottomSheetDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5$lambda$4(AssignmentFragment this$0, BottomSheetDialog dialog, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(radioGroup, "<anonymous parameter 0>");
        if (i == R.id.filter_submited) {
            this$0.getAssignmentViewModel().getAssignment("SUBMITTED", "", this$0.current);
        } else if (i == R.id.filter_notsubmited) {
            this$0.getAssignmentViewModel().getAssignment("NOT SUBMITTED", "", this$0.current);
        } else {
            this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7(final AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            View inflate = this$0.getLayoutInflater().inflate(R.layout.bottom_sheet_sot, (ViewGroup) null);
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.sortBtn);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this$0.requireContext());
            bottomSheetDialog.setContentView(inflate);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda7
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    AssignmentFragment.setUp$lambda$7$lambda$6(AssignmentFragment.this, bottomSheetDialog, radioGroup2, i);
                }
            });
            bottomSheetDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$7$lambda$6(AssignmentFragment this$0, BottomSheetDialog dialog, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(radioGroup, "<anonymous parameter 0>");
        if (i == R.id.sort_old) {
            this$0.getAssignmentViewModel().getAssignment("", "ASC", this$0.current);
        } else if (i == R.id.sort_new) {
            this$0.getAssignmentViewModel().getAssignment("", "DESC", this$0.current);
        } else {
            this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9(final AssignmentFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            View inflate = this$0.getLayoutInflater().inflate(R.layout.bottom_sheet_sot, (ViewGroup) null);
            RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.sortBtn);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this$0.requireContext());
            bottomSheetDialog.setContentView(inflate);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda5
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public final void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    AssignmentFragment.setUp$lambda$9$lambda$8(AssignmentFragment.this, bottomSheetDialog, radioGroup2, i);
                }
            });
            bottomSheetDialog.show();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$9$lambda$8(AssignmentFragment this$0, BottomSheetDialog dialog, RadioGroup radioGroup, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(radioGroup, "<anonymous parameter 0>");
        if (i == R.id.sort_old) {
            this$0.getAssignmentViewModel().getAssignment("", "ASC", this$0.current);
        } else if (i == R.id.sort_new) {
            this$0.getAssignmentViewModel().getAssignment("", "DESC", this$0.current);
        } else {
            this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
        }
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$10(AssignmentFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
        AssignmentFragmentBinding assignmentFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = assignmentFragmentBinding != null ? assignmentFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        Intrinsics.checkNotNullParameter(menu, "menu");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        menu.clear();
        inflater.inflate(R.menu.action_filter, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenSemResponse() {
        getAssignmentViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssignmentFragment.listenSemResponse$lambda$12(AssignmentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$12(AssignmentFragment this$0, Resource resource) {
        Spinner spinner;
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        r2 = null;
        Boolean bool = null;
        if (i != 1) {
            if (i == 2) {
                AssignmentFragmentBinding assignmentFragmentBinding = this$0.get_binding();
                if (assignmentFragmentBinding != null && (swipeRefreshLayout2 = assignmentFragmentBinding.swipeLayout) != null) {
                    bool = Boolean.valueOf(swipeRefreshLayout2.isRefreshing());
                }
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    return;
                }
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            AssignmentFragmentBinding assignmentFragmentBinding2 = this$0.get_binding();
            if (assignmentFragmentBinding2 == null || (recyclerView = assignmentFragmentBinding2.rvAssignment) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        ArrayList<Semester> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.getSpinnerAdapter().addItems(arrayList);
            AssignmentFragmentBinding assignmentFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (assignmentFragmentBinding3 == null || (swipeRefreshLayout = assignmentFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                AssignmentFragmentBinding assignmentFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = assignmentFragmentBinding4 != null ? assignmentFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        AssignmentFragmentBinding assignmentFragmentBinding5 = this$0.get_binding();
                        if (assignmentFragmentBinding5 == null || (spinner = assignmentFragmentBinding5.spinnerSem) == null) {
                            return;
                        }
                        spinner.setSelection(i2);
                        return;
                    }
                }
            }
        }
    }

    private final void listenResponse() {
        getAssignmentViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda6
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssignmentFragment.listenResponse$lambda$14(AssignmentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$14(AssignmentFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            AssignmentResponse assignmentResponse = (AssignmentResponse) resource.getData();
            if (assignmentResponse != null) {
                this$0.showBaseView();
                if (assignmentResponse.getLogin()) {
                    this$0.getAdapter().addItems(assignmentResponse.getAssignments());
                    return;
                }
                return;
            }
            return;
        }
        if (i == 2) {
            this$0.hideBaseView();
            this$0.showProgress();
            return;
        }
        if (i == 3) {
            this$0.hideProgress();
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        AssignmentFragmentBinding assignmentFragmentBinding = this$0.get_binding();
        if (assignmentFragmentBinding == null || (recyclerView = assignmentFragmentBinding.rvAssignment) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.assignment.AssignmentAdapter.AssignmentListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            loadPickerDialog(id);
        } else {
            requestPermission();
        }
    }

    private final void loadPickerDialog(String id) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        UploadAssignmentDialog newInstance = UploadAssignmentDialog.INSTANCE.newInstance(id);
        newInstance.setUploadCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.assignment.AssignmentAdapter.AssignmentListener
    public void deleteAssignment(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_assignment_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                AssignmentFragment.deleteAssignment$lambda$15(AssignmentFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteAssignment$lambda$15(AssignmentFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getAssignmentViewModel().deleteAssignment(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getAssignmentViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AssignmentFragment.listenDeleteResponse$lambda$17(AssignmentFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$17(AssignmentFragment this$0, Resource resource) {
        RecyclerView rvAssignment;
        RecyclerView rvAssignment2;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this$0.showProgress();
                return;
            }
            if (i == 3) {
                this$0.hideProgress();
                this$0.showBaseView();
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            this$0.showBaseView();
            AssignmentFragmentBinding assignmentFragmentBinding = this$0.get_binding();
            if (assignmentFragmentBinding == null || (recyclerView = assignmentFragmentBinding.rvAssignment) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        SuccessResponse successResponse = (SuccessResponse) resource.getData();
        if (successResponse != null) {
            this$0.showBaseView();
            if (successResponse.getLogin() && successResponse.getSuccess()) {
                AssignmentFragmentBinding assignmentFragmentBinding2 = this$0.get_binding();
                if (assignmentFragmentBinding2 != null && (rvAssignment2 = assignmentFragmentBinding2.rvAssignment) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvAssignment2, "rvAssignment");
                    ToastExtKt.showSuccessToast(rvAssignment2, successResponse.getMessage());
                }
                this$0.getAssignmentViewModel().getAssignment("", "", this$0.current);
                return;
            }
            AssignmentFragmentBinding assignmentFragmentBinding3 = this$0.get_binding();
            if (assignmentFragmentBinding3 == null || (rvAssignment = assignmentFragmentBinding3.rvAssignment) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvAssignment, "rvAssignment");
            ToastExtKt.showErrorToast(rvAssignment, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.assignment.AssignmentAdapter.AssignmentListener
    public void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? "/etlab/assignments/" : AppConstant.UPLOAD_ASSIGNMENT_PATH;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            if (checkFileExistence(replace, flag)) {
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                new DownloadManagerHelper(requireContext2).openFile(replace, str);
                return;
            }
            try {
                AssignmentFragmentBinding assignmentFragmentBinding = get_binding();
                if (assignmentFragmentBinding != null && (recyclerView = assignmentFragmentBinding.rvAssignment) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(str, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 4);
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.assignment.AssignmentAdapter.AssignmentListener
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, "/etlab/assignments/");
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_ASSIGNMENT_PATH);
    }

    @Override // in.etuwa.app.ui.assignment.upload.UploadAssignmentDialog.UploadAssignmentCallBack
    public void onDismiss() {
        getAssignmentViewModel().getAssignment("", "", this.current);
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.assignment.AssignmentFragment$$ExternalSyntheticLambda16
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AssignmentFragment.requestPermission$lambda$18(AssignmentFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$18(AssignmentFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        if (requestCode == 1) {
            try {
                if (!(!(grantResults.length == 0)) || grantResults[0] != 0) {
                    if (Build.VERSION.SDK_INT >= 23 && !shouldShowRequestPermissionRationale(permissions[0])) {
                        Context requireContext = requireContext();
                        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                        new ValidChecker(requireContext).showPermissionDialog();
                    } else {
                        Toast.makeText(requireContext(), "Permission Denied, You cannot Upload Profile Image .", 0).show();
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        AssignmentFragmentBinding assignmentFragmentBinding = get_binding();
        if (assignmentFragmentBinding == null || (recyclerView = assignmentFragmentBinding.rvAssignment) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        AssignmentFragmentBinding assignmentFragmentBinding = get_binding();
        if (assignmentFragmentBinding == null || (recyclerView = assignmentFragmentBinding.rvAssignment) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setAssignmentListener(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo.SemDialogCallBack
    public void loadSelectedSem(String id, String sem) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(sem, "sem");
        getAssignmentViewModel().getAssignment("", "", id);
        this.semId = id;
    }
}