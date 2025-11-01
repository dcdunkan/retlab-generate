package in.etuwa.app.ui.exam.series;

import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.DownloadModel;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.exam.ExamFiles;
import in.etuwa.app.data.model.exam.SeriesExamResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.SeriesExamFragmentBinding;
import in.etuwa.app.helper.DownloadManagerHelper;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.helper.ValidChecker;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.exam.ExamListener;
import in.etuwa.app.ui.exam.questions.QuestionDialog;
import in.etuwa.app.ui.exam.submit.SubmitExamDialog;
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

/* compiled from: SeriesExamFragment.kt */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 `2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001`B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u00100\u001a\u00020\u00192\u0006\u00101\u001a\u00020\u0013H\u0016J\b\u00102\u001a\u00020\u0019H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0013H\u0016J\u0018\u00106\u001a\u0002042\u0006\u00107\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0006H\u0017J\b\u00109\u001a\u000204H\u0014J\b\u0010:\u001a\u000204H\u0014J\b\u0010;\u001a\u000204H\u0002J\b\u0010<\u001a\u000204H\u0002J\b\u0010=\u001a\u000204H\u0002J\u0018\u0010>\u001a\u0002042\u0006\u00105\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0013H\u0016J\u0018\u0010@\u001a\u0002042\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020DH\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010C\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J\b\u0010L\u001a\u000204H\u0016J\b\u0010M\u001a\u000204H\u0016J\b\u0010N\u001a\u000204H\u0016J\u0010\u0010O\u001a\u0002042\u0006\u00105\u001a\u00020\u0013H\u0016J-\u0010P\u001a\u0002042\u0006\u0010Q\u001a\u00020\u00062\u000e\u0010R\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130S2\u0006\u0010T\u001a\u00020UH\u0016¢\u0006\u0002\u0010VJ\u001a\u0010W\u001a\u0002042\u0006\u0010X\u001a\u00020F2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J \u0010Y\u001a\u0002042\u0016\u0010Z\u001a\u0012\u0012\u0004\u0012\u00020[0\u0015j\b\u0012\u0004\u0012\u00020[`\u0017H\u0016J\b\u0010\\\u001a\u000204H\u0002J\b\u0010]\u001a\u000204H\u0014J\b\u0010^\u001a\u000204H\u0014J\b\u0010_\u001a\u000204H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u000e\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b-\u0010.¨\u0006a"}, d2 = {"Lin/etuwa/app/ui/exam/series/SeriesExamFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/exam/ExamListener;", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "()V", "REQUEST_CODE", "", "_binding", "Lin/etuwa/app/databinding/SeriesExamFragmentBinding;", "adapter", "Lin/etuwa/app/ui/exam/series/SeriesAdapter;", "getAdapter", "()Lin/etuwa/app/ui/exam/series/SeriesAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/SeriesExamFragmentBinding;", "current", "", "downList", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/DownloadModel;", "Lkotlin/collections/ArrayList;", "flag", "", "onDownloadComplete", "Landroid/content/BroadcastReceiver;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "semId", "getSemId", "()Ljava/lang/String;", "setSemId", "(Ljava/lang/String;)V", "seriesExamViewModel", "Lin/etuwa/app/ui/exam/series/SeriesExamViewModel;", "getSeriesExamViewModel", "()Lin/etuwa/app/ui/exam/series/SeriesExamViewModel;", "seriesExamViewModel$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "checkFileExistence", "fileName", "checkPermissions", "deleteExam", "", "id", "downloadFile", "url", CommonCssConstants.POSITION, "hideBaseView", "hideProgress", "listenDeleteResponse", "listenResponse", "listenSemResponse", "loadSelectedSem", "sem", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onDismiss", "onPickDoc", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onViewCreated", SvgConstants.Tags.VIEW, "openDownloadDialog", "list", "Lin/etuwa/app/data/model/exam/ExamFiles;", "requestPermission", "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SeriesExamFragment extends BaseFragment implements ExamListener, SemListDialogTwo.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int REQUEST_CODE;
    private SeriesExamFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String current;
    private ArrayList<DownloadModel> downList;
    private boolean flag;
    private final BroadcastReceiver onDownloadComplete;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String semId;

    /* renamed from: seriesExamViewModel$delegate, reason: from kotlin metadata */
    private final Lazy seriesExamViewModel;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* compiled from: SeriesExamFragment.kt */
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
    public static final SeriesExamFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SeriesExamFragment() {
        final SeriesExamFragment seriesExamFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(seriesExamFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.seriesExamViewModel = FragmentViewModelLazyKt.createViewModelLazy(seriesExamFragment, Reflection.getOrCreateKotlinClass(SeriesExamViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SeriesExamViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SeriesExamFragment seriesExamFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SeriesAdapter>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.exam.series.SeriesAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SeriesAdapter invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SeriesAdapter.class), b2, b3);
            }
        });
        this.REQUEST_CODE = 1;
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(SeriesExamFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = seriesExamFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
        this.downList = new ArrayList<>();
        this.current = "";
        this.semId = getPreference().getUserSemId();
        this.onDownloadComplete = new BroadcastReceiver() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$onDownloadComplete$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                ArrayList arrayList;
                SeriesAdapter adapter;
                ArrayList arrayList2;
                ArrayList arrayList3;
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                long longExtra = intent.getLongExtra("extra_download_id", -1L);
                try {
                    arrayList = SeriesExamFragment.this.downList;
                    SeriesExamFragment seriesExamFragment3 = SeriesExamFragment.this;
                    int i = 0;
                    for (Object obj : arrayList) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        DownloadModel downloadModel = (DownloadModel) obj;
                        if (downloadModel.getId() == longExtra) {
                            adapter = seriesExamFragment3.getAdapter();
                            arrayList2 = seriesExamFragment3.downList;
                            adapter.notifyDataChanged(((DownloadModel) arrayList2.get(i)).getPosition());
                            arrayList3 = seriesExamFragment3.downList;
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
    public final SeriesExamViewModel getSeriesExamViewModel() {
        return (SeriesExamViewModel) this.seriesExamViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SeriesAdapter getAdapter() {
        return (SeriesAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final SeriesExamFragmentBinding get_binding() {
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

    /* compiled from: SeriesExamFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/exam/series/SeriesExamFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/exam/series/SeriesExamFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SeriesExamFragment newInstance() {
            return new SeriesExamFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = SeriesExamFragmentBinding.inflate(inflater, container, false);
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding != null) {
            seriesExamFragmentBinding.setSeriesExamViewModel(getSeriesExamViewModel());
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = get_binding();
        if (seriesExamFragmentBinding2 != null) {
            seriesExamFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding3 = get_binding();
        if (seriesExamFragmentBinding3 != null) {
            return seriesExamFragmentBinding3.getRoot();
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
        RecyclerView recyclerView;
        RecyclerView.RecycledViewPool recycledViewPool;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.series_exam));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        RecyclerView recyclerView2 = seriesExamFragmentBinding != null ? seriesExamFragmentBinding.rvExam : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setExamListener(this);
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = get_binding();
        if (seriesExamFragmentBinding2 != null && (recyclerView = seriesExamFragmentBinding2.rvExam) != null && (recycledViewPool = recyclerView.getRecycledViewPool()) != null) {
            recycledViewPool.setMaxRecycledViews(0, 0);
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding3 = get_binding();
        Spinner spinner = seriesExamFragmentBinding3 != null ? seriesExamFragmentBinding3.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        listenSemResponse();
        listenResponse();
        SeriesExamFragmentBinding seriesExamFragmentBinding4 = get_binding();
        if (seriesExamFragmentBinding4 != null && (floatingActionButton = seriesExamFragmentBinding4.fabSeriesSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SeriesExamFragment.setUp$lambda$0(SeriesExamFragment.this, view);
                }
            });
        }
        getSeriesExamViewModel().getExams(this.semId);
        SeriesExamFragmentBinding seriesExamFragmentBinding5 = get_binding();
        Spinner spinner2 = seriesExamFragmentBinding5 != null ? seriesExamFragmentBinding5.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$setUp$2
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
                    SeriesExamFragmentBinding seriesExamFragmentBinding6;
                    SeriesExamViewModel seriesExamViewModel;
                    SharedPrefManager preference2;
                    Spinner spinner3;
                    SeriesExamViewModel seriesExamViewModel2;
                    spinnerAdapter = SeriesExamFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = SeriesExamFragment.this.flag;
                    if (z) {
                        seriesExamViewModel2 = SeriesExamFragment.this.getSeriesExamViewModel();
                        seriesExamViewModel2.getExams(semester.getId());
                        SeriesExamFragment.this.current = semester.getId();
                        return;
                    }
                    SeriesExamFragment.this.flag = true;
                    spinnerAdapter2 = SeriesExamFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = SeriesExamFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = SeriesExamFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            seriesExamFragmentBinding6 = SeriesExamFragment.this.get_binding();
                            if (seriesExamFragmentBinding6 != null && (spinner3 = seriesExamFragmentBinding6.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                seriesExamViewModel = SeriesExamFragment.this.getSeriesExamViewModel();
                                preference2 = SeriesExamFragment.this.getPreference();
                                seriesExamViewModel.getExams(preference2.getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        SeriesExamFragmentBinding seriesExamFragmentBinding6 = get_binding();
        if (seriesExamFragmentBinding6 == null || (swipeRefreshLayout = seriesExamFragmentBinding6.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda6
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                SeriesExamFragment.setUp$lambda$1(SeriesExamFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(SeriesExamFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo newInstance = SemListDialogTwo.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SeriesExamFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSeriesExamViewModel().getSemester();
        this$0.getSeriesExamViewModel().getExams(this$0.getPreference().getUserSemId());
        SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = seriesExamFragmentBinding != null ? seriesExamFragmentBinding.swipeLayout : null;
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
        getSeriesExamViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenSemResponse$lambda$3(SeriesExamFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(SeriesExamFragment this$0, Resource resource) {
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
                SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
                if (seriesExamFragmentBinding != null && (swipeRefreshLayout2 = seriesExamFragmentBinding.swipeLayout) != null) {
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
            SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
            if (seriesExamFragmentBinding2 == null || (recyclerView = seriesExamFragmentBinding2.rvExam) == null) {
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
            SeriesExamFragmentBinding seriesExamFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (seriesExamFragmentBinding3 == null || (swipeRefreshLayout = seriesExamFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                SeriesExamFragmentBinding seriesExamFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = seriesExamFragmentBinding4 != null ? seriesExamFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        SeriesExamFragmentBinding seriesExamFragmentBinding5 = this$0.get_binding();
                        if (seriesExamFragmentBinding5 == null || (spinner = seriesExamFragmentBinding5.spinnerSem) == null) {
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
        getSeriesExamViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenResponse$lambda$5(SeriesExamFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(SeriesExamFragment this$0, Resource resource) {
        RecyclerView rvExam;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            SeriesExamResponse seriesExamResponse = (SeriesExamResponse) resource.getData();
            if (seriesExamResponse != null) {
                this$0.showBaseView();
                if (seriesExamResponse.getLogin()) {
                    this$0.getAdapter().addItems(seriesExamResponse.getSeriesExams());
                    return;
                }
                SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
                if (seriesExamFragmentBinding == null || (rvExam = seriesExamFragmentBinding.rvExam) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
                ToastExtKt.showErrorToast(rvExam, seriesExamResponse.getError());
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
            this$0.showBaseView();
            return;
        }
        if (i != 4) {
            return;
        }
        this$0.hideProgress();
        this$0.showBaseView();
        SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
        if (seriesExamFragmentBinding2 == null || (recyclerView = seriesExamFragmentBinding2.rvExam) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void onPickDoc(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        if (new ValidChecker(requireContext).checkPermission() || Build.VERSION.SDK_INT >= 33) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            SubmitExamDialog newInstance = SubmitExamDialog.INSTANCE.newInstance(id, 0);
            newInstance.setUploadCallBack(this);
            newInstance.show(childFragmentManager, (String) null);
            return;
        }
        requestPermission();
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void downloadFile(String url, int position) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(url, "url");
        String replace = new Regex("[^A-Za-z0-9.]").replace(StringsKt.substringAfterLast$default(url, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), "");
        if (checkPermissions()) {
            System.out.println((Object) "");
        } else {
            System.out.println((Object) "");
        }
        if (Build.VERSION.SDK_INT >= 34 || checkPermissions()) {
            if (checkFileExistence(replace)) {
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                new DownloadManagerHelper(requireContext).openFile(replace, AppConstant.UPLOAD_SERIES_EXAM_PATH);
                return;
            }
            try {
                SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
                if (seriesExamFragmentBinding != null && (recyclerView = seriesExamFragmentBinding.rvExam) != null) {
                    String string = getString(R.string.download_started);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.download_started)");
                    ToastExtKt.showInfoToast(recyclerView, string);
                }
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                long startDownloading = new DownloadManagerHelper(requireContext2).startDownloading(AppConstant.UPLOAD_SERIES_EXAM_PATH, url);
                Context context = getContext();
                if (context != null) {
                    context.registerReceiver(this.onDownloadComplete, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
                }
                this.downList.add(new DownloadModel(startDownloading, position));
                return;
            } catch (Exception e) {
                Log.e("DownloadError", "Error during download: " + e.getMessage());
                return;
            }
        }
        requestPermission();
    }

    private final boolean checkPermissions() {
        int checkSelfPermission = ContextCompat.checkSelfPermission(requireContext(), "android.permission.READ_EXTERNAL_STORAGE");
        int checkSelfPermission2 = ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        Log.d("Permissions", "Read Permission: " + checkSelfPermission + ", Write Permission: " + checkSelfPermission2);
        return checkSelfPermission == 0 && checkSelfPermission2 == 0;
    }

    private final void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.WRITE_EXTERNAL_STORAGE") || ActivityCompat.shouldShowRequestPermissionRationale(requireActivity(), "android.permission.READ_EXTERNAL_STORAGE")) {
            new AlertDialog.Builder(requireContext()).setTitle(getString(R.string.storage_permission_title)).setMessage(getString(R.string.storage_permission)).setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    SeriesExamFragment.requestPermission$lambda$6(SeriesExamFragment.this, dialogInterface, i);
                }
            }).create().show();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this.REQUEST_CODE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestPermission$lambda$6(SeriesExamFragment this$0, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActivityCompat.requestPermissions(this$0.requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"}, this$0.REQUEST_CODE);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == this.REQUEST_CODE) {
            if ((!(grantResults.length == 0)) && grantResults[0] == 0) {
                return;
            }
            Toast.makeText(requireContext(), "Permission denied. Unable to download files.", 0).show();
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public boolean checkFileExistence(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return new ValidChecker(requireContext).checkFileExistence(fileName, AppConstant.UPLOAD_SERIES_EXAM_PATH);
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void deleteExam(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(getString(R.string.delete_exam_msg));
        builder.setPositiveButton("delete", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SeriesExamFragment.deleteExam$lambda$7(SeriesExamFragment.this, id, dialogInterface, i);
            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void deleteExam$lambda$7(SeriesExamFragment this$0, String id, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        this$0.getSeriesExamViewModel().deleteExam(id);
        this$0.listenDeleteResponse();
    }

    private final void listenDeleteResponse() {
        getSeriesExamViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.exam.series.SeriesExamFragment$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SeriesExamFragment.listenDeleteResponse$lambda$9(SeriesExamFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$9(SeriesExamFragment this$0, Resource resource) {
        RecyclerView rvExam;
        RecyclerView rvExam2;
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
            SeriesExamFragmentBinding seriesExamFragmentBinding = this$0.get_binding();
            if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
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
                SeriesExamFragmentBinding seriesExamFragmentBinding2 = this$0.get_binding();
                if (seriesExamFragmentBinding2 != null && (rvExam2 = seriesExamFragmentBinding2.rvExam) != null) {
                    Intrinsics.checkNotNullExpressionValue(rvExam2, "rvExam");
                    ToastExtKt.showSuccessToast(rvExam2, successResponse.getMessage());
                }
                this$0.getSeriesExamViewModel().getExams(this$0.current);
                return;
            }
            SeriesExamFragmentBinding seriesExamFragmentBinding3 = this$0.get_binding();
            if (seriesExamFragmentBinding3 == null || (rvExam = seriesExamFragmentBinding3.rvExam) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(rvExam, "rvExam");
            ToastExtKt.showErrorToast(rvExam, successResponse.getError());
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void openDownloadDialog(ArrayList<ExamFiles> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            QuestionDialog.INSTANCE.newInstance(list, true).show(childFragmentManager, (String) null);
        } catch (Exception unused) {
        }
    }

    @Override // in.etuwa.app.ui.exam.ExamListener
    public void onDismiss() {
        getSeriesExamViewModel().getExams(this.current);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        SeriesExamFragmentBinding seriesExamFragmentBinding = get_binding();
        if (seriesExamFragmentBinding == null || (recyclerView = seriesExamFragmentBinding.rvExam) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setExamListener(null);
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
        getSeriesExamViewModel().getExams(id);
    }
}