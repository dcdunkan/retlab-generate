package in.etuwa.app.ui.university;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.university.UniversityResultResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.UniversityResultFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.university.UniversityResultAdapter;
import in.etuwa.app.utils.AppConstant;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: UniversityResultFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020&H\u0016J \u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020&H\u0002J\b\u0010.\u001a\u00020*H\u0014J\b\u0010/\u001a\u00020*H\u0014J\b\u00100\u001a\u00020*H\u0002J\u0012\u00101\u001a\u00020*2\b\u00102\u001a\u0004\u0018\u000103H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010:\u001a\u00020*H\u0016J\u001a\u0010;\u001a\u00020*2\u0006\u0010<\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0014J\b\u0010?\u001a\u00020*H\u0014J\b\u0010@\u001a\u00020*H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u000b\u001a\u0004\b\"\u0010#¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/university/UniversityResultFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/university/UniversityResultAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/UniversityResultFragmentBinding;", "adapter", "Lin/etuwa/app/ui/university/UniversityResultAdapter;", "getAdapter", "()Lin/etuwa/app/ui/university/UniversityResultAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/UniversityResultFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "universityResultViewModel", "Lin/etuwa/app/ui/university/UniversityResultViewModel;", "getUniversityResultViewModel", "()Lin/etuwa/app/ui/university/UniversityResultViewModel;", "universityResultViewModel$delegate", "checkFileExistence", "", "fileName", "flag", "downloadClicked", "", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UniversityResultFragment extends BaseFragment implements UniversityResultAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private UniversityResultFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private String id;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: universityResultViewModel$delegate, reason: from kotlin metadata */
    private final Lazy universityResultViewModel;

    /* compiled from: UniversityResultFragment.kt */
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
    public static final UniversityResultFragment newInstance(String str) {
        return INSTANCE.newInstance(str);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public UniversityResultFragment() {
        final UniversityResultFragment universityResultFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(universityResultFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.universityResultViewModel = FragmentViewModelLazyKt.createViewModelLazy(universityResultFragment, Reflection.getOrCreateKotlinClass(UniversityResultViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(UniversityResultViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final UniversityResultFragment universityResultFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<UniversityResultAdapter>() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.university.UniversityResultAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final UniversityResultAdapter invoke() {
                ComponentCallbacks componentCallbacks = universityResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(UniversityResultAdapter.class), b2, b3);
            }
        });
        this.downList = new ArrayList<>();
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = universityResultFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                UniversityResultAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = UniversityResultFragment.this.downList;
                    UniversityResultFragment universityResultFragment3 = UniversityResultFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = universityResultFragment3.getAdapter();
                            arrayList2 = universityResultFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = universityResultFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final UniversityResultViewModel getUniversityResultViewModel() {
        return (UniversityResultViewModel) this.universityResultViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final UniversityResultAdapter getAdapter() {
        return (UniversityResultAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final UniversityResultFragmentBinding get_binding() {
        return this._binding;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: UniversityResultFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/university/UniversityResultFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/university/UniversityResultFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UniversityResultFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            UniversityResultFragment universityResultFragment = new UniversityResultFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            universityResultFragment.setArguments(bundle);
            return universityResultFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.id = arguments.getString("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = UniversityResultFragmentBinding.inflate(inflater, container, false);
        UniversityResultFragmentBinding universityResultFragmentBinding = get_binding();
        if (universityResultFragmentBinding != null) {
            universityResultFragmentBinding.setUniversityResultViewModel(getUniversityResultViewModel());
        }
        UniversityResultFragmentBinding universityResultFragmentBinding2 = get_binding();
        if (universityResultFragmentBinding2 != null) {
            universityResultFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        UniversityResultFragmentBinding universityResultFragmentBinding3 = get_binding();
        if (universityResultFragmentBinding3 != null) {
            return universityResultFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("University Result");
        }
        listenResponse();
        getPreference().setNewLogin(false);
        UniversityResultViewModel universityResultViewModel = getUniversityResultViewModel();
        String str = this.id;
        Intrinsics.checkNotNull(str);
        universityResultViewModel.getUniversityResultResponse(str);
        UniversityResultFragmentBinding universityResultFragmentBinding = get_binding();
        RecyclerView recyclerView = universityResultFragmentBinding != null ? universityResultFragmentBinding.rvResultList : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
    }

    private final void listenResponse() {
        getUniversityResultViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                UniversityResultFragment.listenResponse$lambda$2(UniversityResultFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(UniversityResultFragment this$0, Resource resource) {
        RecyclerView rvResultList;
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
                return;
            }
            if (i != 4) {
                return;
            }
            this$0.hideProgress();
            UniversityResultFragmentBinding universityResultFragmentBinding = this$0.get_binding();
            if (universityResultFragmentBinding == null || (recyclerView = universityResultFragmentBinding.rvResultList) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        UniversityResultResponse universityResultResponse = (UniversityResultResponse) resource.getData();
        if (universityResultResponse != null) {
            if (Intrinsics.areEqual(universityResultResponse.getError(), "")) {
                UniversityResultFragmentBinding universityResultFragmentBinding2 = this$0.get_binding();
                TextView textView = universityResultFragmentBinding2 != null ? universityResultFragmentBinding2.tvEarnedCredit : null;
                if (textView != null) {
                    textView.setText("Earned Credits  " + universityResultResponse.getEarned_credit());
                }
                UniversityResultFragmentBinding universityResultFragmentBinding3 = this$0.get_binding();
                TextView textView2 = universityResultFragmentBinding3 != null ? universityResultFragmentBinding3.tvSgpa : null;
                if (textView2 != null) {
                    textView2.setText("SGPA  " + universityResultResponse.getSgpa());
                }
                UniversityResultFragmentBinding universityResultFragmentBinding4 = this$0.get_binding();
                TextView textView3 = universityResultFragmentBinding4 != null ? universityResultFragmentBinding4.regNo : null;
                if (textView3 != null) {
                    textView3.setText(universityResultResponse.getReg_no());
                }
                UniversityResultFragmentBinding universityResultFragmentBinding5 = this$0.get_binding();
                TextView textView4 = universityResultFragmentBinding5 != null ? universityResultFragmentBinding5.progName : null;
                if (textView4 != null) {
                    textView4.setText(universityResultResponse.getProgram());
                }
                UniversityResultFragmentBinding universityResultFragmentBinding6 = this$0.get_binding();
                TextView textView5 = universityResultFragmentBinding6 != null ? universityResultFragmentBinding6.branchName : null;
                if (textView5 != null) {
                    textView5.setText(universityResultResponse.getBranch());
                }
                UniversityResultFragmentBinding universityResultFragmentBinding7 = this$0.get_binding();
                TextView textView6 = universityResultFragmentBinding7 != null ? universityResultFragmentBinding7.semName : null;
                if (textView6 != null) {
                    textView6.setText(universityResultResponse.getSemester());
                }
                if (universityResultResponse.getResult().size() > 0) {
                    this$0.getAdapter().addItems(universityResultResponse.getResult());
                    return;
                } else {
                    this$0.getAdapter().clear();
                    return;
                }
            }
            UniversityResultFragmentBinding universityResultFragmentBinding8 = this$0.get_binding();
            if (universityResultFragmentBinding8 != null && (rvResultList = universityResultFragmentBinding8.rvResultList) != null) {
                Intrinsics.checkNotNullExpressionValue(rvResultList, "rvResultList");
                ToastExtKt.showInfoToast(rvResultList, universityResultResponse.getError());
            }
            this$0.getAdapter().clear();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    private final void downloadClicked(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? AppConstant.INTERNSHIP_PATH : AppConstant.UPLOAD_INTERNSHIP_PATH;
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
                UniversityResultFragmentBinding universityResultFragmentBinding = get_binding();
                if (universityResultFragmentBinding != null && (recyclerView = universityResultFragmentBinding.rvResultList) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext3).startDownloading(str, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.university.UniversityResultAdapter.CallBack
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.INTERNSHIP_PATH);
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_INTERNSHIP_PATH);
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.university.UniversityResultFragment$$ExternalSyntheticLambda1
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        UniversityResultFragment.requestPermission$lambda$3(UniversityResultFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$3(UniversityResultFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
    }
}