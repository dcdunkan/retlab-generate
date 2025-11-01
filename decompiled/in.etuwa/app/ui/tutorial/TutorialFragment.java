package in.etuwa.app.ui.tutorial;

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
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.tutorial.TutorialResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.TutorialFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.tutorial.TutorialAdapter;
import in.etuwa.app.ui.tutorial.upload.UploadTutorialDialog;
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
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: TutorialFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\u0018\u0000 J2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001JB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0016J \u0010(\u001a\u00020&2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020+2\u0006\u0010$\u001a\u00020!H\u0016J\b\u0010,\u001a\u00020&H\u0014J\b\u0010-\u001a\u00020&H\u0014J\b\u0010.\u001a\u00020&H\u0002J\b\u0010/\u001a\u00020&H\u0002J\u0010\u00100\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0002J&\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020&H\u0016J\b\u0010:\u001a\u00020&H\u0016J\b\u0010;\u001a\u00020&H\u0016J\u0010\u0010<\u001a\u00020&2\u0006\u0010'\u001a\u00020#H\u0016J-\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020+2\u000e\u0010?\u001a\n\u0012\u0006\b\u0001\u0012\u00020#0@2\u0006\u0010A\u001a\u00020BH\u0016¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u0002022\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u0010F\u001a\u00020&H\u0002J\b\u0010G\u001a\u00020&H\u0014J\b\u0010H\u001a\u00020&H\u0014J\b\u0010I\u001a\u00020&H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u001d\u0010\u001e¨\u0006K"}, d2 = {"Lin/etuwa/app/ui/tutorial/TutorialFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/tutorial/TutorialAdapter$TutorialListener;", "Lin/etuwa/app/ui/tutorial/upload/UploadTutorialDialog$UploadTutorialCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/TutorialFragmentBinding;", "adapter", "Lin/etuwa/app/ui/tutorial/TutorialAdapter;", "getAdapter", "()Lin/etuwa/app/ui/tutorial/TutorialAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/TutorialFragmentBinding;", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "tutorialViewModel", "Lin/etuwa/app/ui/tutorial/TutorialViewModel;", "getTutorialViewModel", "()Lin/etuwa/app/ui/tutorial/TutorialViewModel;", "tutorialViewModel$delegate", "checkFileExistence", "", "fileName", "", "flag", "deleteTutorials", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "", "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "loadPickerDialog", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TutorialFragment extends BaseFragment implements TutorialAdapter.TutorialListener, UploadTutorialDialog.UploadTutorialCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private TutorialFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private ArrayList<DownloadModel> downList;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: tutorialViewModel$delegate, reason: from kotlin metadata */
    private final Lazy tutorialViewModel;

    /* compiled from: TutorialFragment.kt */
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
    public static final TutorialFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public TutorialFragment() {
        final TutorialFragment tutorialFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(tutorialFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.tutorialViewModel = FragmentViewModelLazyKt.createViewModelLazy(tutorialFragment, Reflection.getOrCreateKotlinClass(TutorialViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(TutorialViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final TutorialFragment tutorialFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TutorialAdapter>() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.tutorial.TutorialAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final TutorialAdapter invoke() {
                ComponentCallbacks componentCallbacks = tutorialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(TutorialAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = tutorialFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
        this.downList = new ArrayList<>();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                TutorialAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = TutorialFragment.this.downList;
                    TutorialFragment tutorialFragment3 = TutorialFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = tutorialFragment3.getAdapter();
                            arrayList2 = tutorialFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = tutorialFragment3.downList;
                            arrayList3.remove(new DownloadModel(downloadModel.getId(), i));
                        }
                        i = i2;
                    }
                } catch (Exception unused) {
                }
            }
        };
    }

    private final TutorialViewModel getTutorialViewModel() {
        return (TutorialViewModel) this.tutorialViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TutorialAdapter getAdapter() {
        return (TutorialAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final TutorialFragmentBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* compiled from: TutorialFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/tutorial/TutorialFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/tutorial/TutorialFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final TutorialFragment newInstance() {
            return new TutorialFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = TutorialFragmentBinding.inflate(inflater, container, false);
        TutorialFragmentBinding tutorialFragmentBinding = get_binding();
        if (tutorialFragmentBinding != null) {
            tutorialFragmentBinding.setTutorialViewModel(getTutorialViewModel());
        }
        TutorialFragmentBinding tutorialFragmentBinding2 = get_binding();
        if (tutorialFragmentBinding2 != null) {
            tutorialFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        TutorialFragmentBinding tutorialFragmentBinding3 = get_binding();
        if (tutorialFragmentBinding3 != null) {
            return tutorialFragmentBinding3.getRoot();
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
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.tutorial));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        TutorialFragmentBinding tutorialFragmentBinding = get_binding();
        RecyclerView recyclerView2 = tutorialFragmentBinding != null ? tutorialFragmentBinding.rvTutorial : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        TutorialFragmentBinding tutorialFragmentBinding2 = get_binding();
        if (tutorialFragmentBinding2 != null && (recyclerView = tutorialFragmentBinding2.rvTutorial) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.setMaxRecycledViews(0, 0);
        }
        listenResponse();
        TutorialFragmentBinding tutorialFragmentBinding3 = get_binding();
        if (tutorialFragmentBinding3 == null || (swipeRefreshLayout = tutorialFragmentBinding3.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$$ExternalSyntheticLambda1
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                TutorialFragment.setUp$lambda$0(TutorialFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(TutorialFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getTutorialViewModel().getTutorials();
        TutorialFragmentBinding tutorialFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = tutorialFragmentBinding != null ? tutorialFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getTutorialViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TutorialFragment.listenResponse$lambda$2(TutorialFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(TutorialFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            TutorialResponse tutorialResponse = (TutorialResponse) resource.getData();
            if (tutorialResponse != null) {
                this$0.showBaseView();
                if (tutorialResponse.getLogin()) {
                    this$0.getAdapter().addItems(tutorialResponse.getTutorials());
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
        TutorialFragmentBinding tutorialFragmentBinding = this$0.get_binding();
        if (tutorialFragmentBinding == null || (recyclerView = tutorialFragmentBinding.rvTutorial) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.tutorial.TutorialAdapter.TutorialListener
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
        UploadTutorialDialog newInstance = UploadTutorialDialog.INSTANCE.newInstance(id);
        newInstance.setUploadCallBack(this);
        newInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.tutorial.TutorialAdapter.TutorialListener
    public void deleteTutorials(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_assignment_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                TutorialFragment.deleteTutorials$lambda$3(TutorialFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteTutorials$lambda$3(TutorialFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getTutorialViewModel().deleteTutorial(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getTutorialViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TutorialFragment.listenDeleteResponse$lambda$5(TutorialFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$5(TutorialFragment this$0, Resource resource) {
        RecyclerView rvTutorial;
        RecyclerView rvTutorial2;
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
            TutorialFragmentBinding tutorialFragmentBinding = this$0.get_binding();
            if (tutorialFragmentBinding == null || (recyclerView = tutorialFragmentBinding.rvTutorial) == null) {
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
                TutorialFragmentBinding tutorialFragmentBinding2 = this$0.get_binding();
                if (tutorialFragmentBinding2 != null && (rvTutorial2 = tutorialFragmentBinding2.rvTutorial) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvTutorial2, "rvTutorial");
                    ToastExtKt.showSuccessToast(rvTutorial2, successResponse.getMessage());
                }
                this$0.getTutorialViewModel().getTutorials();
                return;
            }
            TutorialFragmentBinding tutorialFragmentBinding3 = this$0.get_binding();
            if (tutorialFragmentBinding3 == null || (rvTutorial = tutorialFragmentBinding3.rvTutorial) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvTutorial, "rvTutorial");
            ToastExtKt.showErrorToast(rvTutorial, successResponse.getMessage());
        }
    }

    @Override // in.etuwa.app.ui.tutorial.TutorialAdapter.TutorialListener
    public void downloadFile(String url, int position, boolean flag) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        String str = flag ? AppConstant.TUTORIAL_PATH : AppConstant.UPLOAD_TUTORIAL_PATH;
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
                TutorialFragmentBinding tutorialFragmentBinding = get_binding();
                if (tutorialFragmentBinding != null && (recyclerView = tutorialFragmentBinding.rvTutorial) != null) {
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

    @Override // in.etuwa.app.ui.tutorial.TutorialAdapter.TutorialListener
    public boolean checkFileExistence(String fileName, boolean flag) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        if (flag) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.TUTORIAL_PATH);
        }
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        return new ValidChecker(requireContext2).checkFileExistence(fileName, AppConstant.UPLOAD_TUTORIAL_PATH);
    }

    @Override // in.etuwa.app.ui.tutorial.upload.UploadTutorialDialog.UploadTutorialCallBack
    public void onDismiss() {
        getTutorialViewModel().getTutorials();
    }

    private final void requestPermission() {
        try {
            if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") && ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
                new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.tutorial.TutorialFragment$$ExternalSyntheticLambda3
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        TutorialFragment.requestPermission$lambda$6(TutorialFragment.this, dialogInterface, i);
                    }
                }).create().show();
            } else {
                ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(TutorialFragment this$0, DialogInterface dialogInterface, int i) {
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
        TutorialFragmentBinding tutorialFragmentBinding = get_binding();
        if (tutorialFragmentBinding == null || (recyclerView = tutorialFragmentBinding.rvTutorial) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        TutorialFragmentBinding tutorialFragmentBinding = get_binding();
        if (tutorialFragmentBinding == null || (recyclerView = tutorialFragmentBinding.rvTutorial) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setCallBack(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}