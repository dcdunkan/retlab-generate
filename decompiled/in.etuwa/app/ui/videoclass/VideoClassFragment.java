package in.etuwa.app.ui.videoclass;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
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
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.Semester;
import in.etuwa.app.data.model.video.VideoResponse;
import in.etuwa.app.data.model.video.Videos;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.VideoClassFragmentBinding;
import in.etuwa.app.helper.SemesterSpinnerAdapter;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.result.session.semlistdialogsession.SemListDialogTwo;
import in.etuwa.app.ui.videoclass.VideoClassAdapter;
import in.etuwa.app.utils.ActivityMediator;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: VideoClassFragment.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001AB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010#\u001a\u00020$H\u0014J\b\u0010%\u001a\u00020$H\u0014J\b\u0010&\u001a\u00020$H\u0002J\b\u0010'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020$2\u0006\u0010,\u001a\u00020\u00112\u0006\u0010-\u001a\u00020\u0011H\u0016J\u0018\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00101\u001a\u0002052\b\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020$H\u0016J\u001a\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u0002042\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010>\u001a\u00020$H\u0014J\b\u0010?\u001a\u00020$H\u0014J\b\u0010@\u001a\u00020$H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b \u0010!¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/videoclass/VideoClassFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/videoclass/VideoClassAdapter$PlayerCallBack;", "Lin/etuwa/app/ui/result/session/semlistdialogsession/SemListDialogTwo$SemDialogCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/VideoClassFragmentBinding;", "adapter", "Lin/etuwa/app/ui/videoclass/VideoClassAdapter;", "getAdapter", "()Lin/etuwa/app/ui/videoclass/VideoClassAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/VideoClassFragmentBinding;", "current", "", "flag", "", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "spinnerAdapter", "Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "getSpinnerAdapter", "()Lin/etuwa/app/helper/SemesterSpinnerAdapter;", "spinnerAdapter$delegate", "videoClassViewModel", "Lin/etuwa/app/ui/videoclass/VideoClassViewModel;", "getVideoClassViewModel", "()Lin/etuwa/app/ui/videoclass/VideoClassViewModel;", "videoClassViewModel$delegate", "hideBaseView", "", "hideProgress", "listenResponse", "listenSemResponse", "loadPlayer", "video", "Lin/etuwa/app/data/model/video/Videos;", "loadSelectedSem", "id", "sem", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoClassFragment extends BaseFragment implements VideoClassAdapter.PlayerCallBack, SemListDialogTwo.SemDialogCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private VideoClassFragmentBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String current;
    private boolean flag;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: spinnerAdapter$delegate, reason: from kotlin metadata */
    private final Lazy spinnerAdapter;

    /* renamed from: videoClassViewModel$delegate, reason: from kotlin metadata */
    private final Lazy videoClassViewModel;

    /* compiled from: VideoClassFragment.kt */
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
    public static final VideoClassFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public VideoClassFragment() {
        final VideoClassFragment videoClassFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(videoClassFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.videoClassViewModel = FragmentViewModelLazyKt.createViewModelLazy(videoClassFragment, Reflection.getOrCreateKotlinClass(VideoClassViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(VideoClassViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final VideoClassFragment videoClassFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<VideoClassAdapter>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.videoclass.VideoClassAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final VideoClassAdapter invoke() {
                ComponentCallbacks componentCallbacks = videoClassFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(VideoClassAdapter.class), b2, b3);
            }
        });
        final Function0<ParametersHolder> function02 = new Function0<ParametersHolder>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$spinnerAdapter$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final ParametersHolder invoke() {
                return ParametersHolderKt.parametersOf(VideoClassFragment.this.requireActivity());
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        this.spinnerAdapter = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SemesterSpinnerAdapter>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.helper.SemesterSpinnerAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SemesterSpinnerAdapter invoke() {
                ComponentCallbacks componentCallbacks = videoClassFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SemesterSpinnerAdapter.class), b4, function02);
            }
        });
        this.current = "";
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b5 = 0 == true ? 1 : 0;
        final byte b6 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = videoClassFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b5, b6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoClassViewModel getVideoClassViewModel() {
        return (VideoClassViewModel) this.videoClassViewModel.getValue();
    }

    private final VideoClassAdapter getAdapter() {
        return (VideoClassAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final VideoClassFragmentBinding get_binding() {
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

    /* compiled from: VideoClassFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/videoclass/VideoClassFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/videoclass/VideoClassFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final VideoClassFragment newInstance() {
            return new VideoClassFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = VideoClassFragmentBinding.inflate(inflater, container, false);
        VideoClassFragmentBinding videoClassFragmentBinding = get_binding();
        if (videoClassFragmentBinding != null) {
            videoClassFragmentBinding.setVideoClassViewModel(getVideoClassViewModel());
        }
        VideoClassFragmentBinding videoClassFragmentBinding2 = get_binding();
        if (videoClassFragmentBinding2 != null) {
            videoClassFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        VideoClassFragmentBinding videoClassFragmentBinding3 = get_binding();
        if (videoClassFragmentBinding3 != null) {
            return videoClassFragmentBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.videotutorial));
        }
        hideBaseView();
        getPreference().setNewLogin(false);
        VideoClassFragmentBinding videoClassFragmentBinding = get_binding();
        RecyclerView recyclerView = videoClassFragmentBinding != null ? videoClassFragmentBinding.rvVideos : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setPlayerCallBack(this);
        VideoClassFragmentBinding videoClassFragmentBinding2 = get_binding();
        Spinner spinner = videoClassFragmentBinding2 != null ? videoClassFragmentBinding2.spinnerSem : null;
        if (spinner != null) {
            spinner.setAdapter((SpinnerAdapter) getSpinnerAdapter());
        }
        getVideoClassViewModel().getVideoClass(getPreference().getUserSemId());
        listenSemResponse();
        listenResponse();
        VideoClassFragmentBinding videoClassFragmentBinding3 = get_binding();
        if (videoClassFragmentBinding3 != null && (floatingActionButton = videoClassFragmentBinding3.fabVideoSemester) != null) {
            floatingActionButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoClassFragment.setUp$lambda$0(VideoClassFragment.this, view);
                }
            });
        }
        VideoClassFragmentBinding videoClassFragmentBinding4 = get_binding();
        Spinner spinner2 = videoClassFragmentBinding4 != null ? videoClassFragmentBinding4.spinnerSem : null;
        if (spinner2 != null) {
            spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$setUp$2
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
                    VideoClassFragmentBinding videoClassFragmentBinding5;
                    VideoClassViewModel videoClassViewModel;
                    SharedPrefManager preference2;
                    Spinner spinner3;
                    VideoClassViewModel videoClassViewModel2;
                    spinnerAdapter = VideoClassFragment.this.getSpinnerAdapter();
                    Semester semester = spinnerAdapter.getSemester(position);
                    z = VideoClassFragment.this.flag;
                    if (z) {
                        videoClassViewModel2 = VideoClassFragment.this.getVideoClassViewModel();
                        videoClassViewModel2.getVideoClass(semester.getId());
                        VideoClassFragment.this.current = semester.getId();
                        return;
                    }
                    VideoClassFragment.this.flag = true;
                    spinnerAdapter2 = VideoClassFragment.this.getSpinnerAdapter();
                    int count = spinnerAdapter2.getCount();
                    for (int i = 0; i < count; i++) {
                        preference = VideoClassFragment.this.getPreference();
                        String userSemId = preference.getUserSemId();
                        spinnerAdapter3 = VideoClassFragment.this.getSpinnerAdapter();
                        if (Intrinsics.areEqual(userSemId, spinnerAdapter3.getSemester(i).getId())) {
                            videoClassFragmentBinding5 = VideoClassFragment.this.get_binding();
                            if (videoClassFragmentBinding5 != null && (spinner3 = videoClassFragmentBinding5.spinnerSem) != null) {
                                spinner3.setSelection(i);
                            }
                            if (position == 0) {
                                videoClassViewModel = VideoClassFragment.this.getVideoClassViewModel();
                                preference2 = VideoClassFragment.this.getPreference();
                                videoClassViewModel.getVideoClass(preference2.getUserSemId());
                                return;
                            }
                            return;
                        }
                    }
                }
            });
        }
        VideoClassFragmentBinding videoClassFragmentBinding5 = get_binding();
        if (videoClassFragmentBinding5 == null || (swipeRefreshLayout = videoClassFragmentBinding5.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                VideoClassFragment.setUp$lambda$1(VideoClassFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(VideoClassFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SemListDialogTwo newInstance = SemListDialogTwo.INSTANCE.newInstance();
        newInstance.setCallBack(this$0);
        newInstance.show(childFragmentManager, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(VideoClassFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getVideoClassViewModel().getVideoClass(this$0.current);
        VideoClassFragmentBinding videoClassFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = videoClassFragmentBinding != null ? videoClassFragmentBinding.swipeLayout : null;
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
        getVideoClassViewModel().getSemResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoClassFragment.listenSemResponse$lambda$3(VideoClassFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenSemResponse$lambda$3(VideoClassFragment this$0, Resource resource) {
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
                VideoClassFragmentBinding videoClassFragmentBinding = this$0.get_binding();
                if (videoClassFragmentBinding != null && (swipeRefreshLayout2 = videoClassFragmentBinding.swipeLayout) != null) {
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
            VideoClassFragmentBinding videoClassFragmentBinding2 = this$0.get_binding();
            if (videoClassFragmentBinding2 == null || (recyclerView = videoClassFragmentBinding2.rvVideos) == null) {
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
            VideoClassFragmentBinding videoClassFragmentBinding3 = this$0.get_binding();
            Boolean valueOf = (videoClassFragmentBinding3 == null || (swipeRefreshLayout = videoClassFragmentBinding3.swipeLayout) == null) ? null : Boolean.valueOf(swipeRefreshLayout.isRefreshing());
            Intrinsics.checkNotNull(valueOf);
            if (valueOf.booleanValue()) {
                VideoClassFragmentBinding videoClassFragmentBinding4 = this$0.get_binding();
                SwipeRefreshLayout swipeRefreshLayout3 = videoClassFragmentBinding4 != null ? videoClassFragmentBinding4.swipeLayout : null;
                if (swipeRefreshLayout3 != null) {
                    swipeRefreshLayout3.setRefreshing(false);
                }
                int count = this$0.getSpinnerAdapter().getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    if (Intrinsics.areEqual(this$0.getPreference().getUserSemId(), this$0.getSpinnerAdapter().getSemester(i2).getId())) {
                        VideoClassFragmentBinding videoClassFragmentBinding5 = this$0.get_binding();
                        if (videoClassFragmentBinding5 == null || (spinner = videoClassFragmentBinding5.spinnerSem) == null) {
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
        getVideoClassViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.videoclass.VideoClassFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VideoClassFragment.listenResponse$lambda$5(VideoClassFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$5(VideoClassFragment this$0, Resource resource) {
        RecyclerView rvVideos;
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            VideoResponse videoResponse = (VideoResponse) resource.getData();
            if (videoResponse != null) {
                this$0.showBaseView();
                if (videoResponse.getLogin()) {
                    this$0.getAdapter().addItems(videoResponse.getVideos());
                    return;
                }
                VideoClassFragmentBinding videoClassFragmentBinding = this$0.get_binding();
                if (videoClassFragmentBinding == null || (rvVideos = videoClassFragmentBinding.rvVideos) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvVideos, "rvVideos");
                ToastExtKt.showErrorToast(rvVideos, videoResponse.getError());
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
        VideoClassFragmentBinding videoClassFragmentBinding2 = this$0.get_binding();
        if (videoClassFragmentBinding2 == null || (recyclerView = videoClassFragmentBinding2.rvVideos) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    @Override // in.etuwa.app.ui.videoclass.VideoClassAdapter.PlayerCallBack
    public void loadPlayer(Videos video) {
        Intrinsics.checkNotNullParameter(video, "video");
        getVideoClassViewModel().watchVideoClass(video.getId(), video.getUrl());
        try {
            if (video.getType() == 0) {
                ActivityMediator activityMediator = ActivityMediator.INSTANCE;
                Context requireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                activityMediator.startYoutubeActivity(requireContext, video.getUrl());
            } else {
                ActivityMediator activityMediator2 = ActivityMediator.INSTANCE;
                Context requireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
                activityMediator2.startVideoPlayerActivity(requireContext2, video.getUrl());
            }
        } catch (Exception unused) {
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        VideoClassFragmentBinding videoClassFragmentBinding = get_binding();
        if (videoClassFragmentBinding == null || (recyclerView = videoClassFragmentBinding.rvVideos) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        VideoClassFragmentBinding videoClassFragmentBinding = get_binding();
        if (videoClassFragmentBinding == null || (recyclerView = videoClassFragmentBinding.rvVideos) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        getAdapter().setPlayerCallBack(null);
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
        getVideoClassViewModel().getVideoClass(id);
    }
}