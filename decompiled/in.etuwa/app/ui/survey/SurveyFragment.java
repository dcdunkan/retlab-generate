package in.etuwa.app.ui.survey;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.survey.Survey;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentSurveyBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.survey.SurveyAdapter;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: SurveyFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010,\u001a\u00020(H\u0014J\b\u0010-\u001a\u00020(H\u0014J\b\u0010.\u001a\u00020(H\u0002J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u0001062\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u001a\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u0002062\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u0010>\u001a\u00020(H\u0014J\b\u0010?\u001a\u00020(H\u0014J\b\u0010@\u001a\u00020(H\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%¨\u0006B"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/survey/SurveyAdapter$SurveyCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentSurveyBinding;", "adapter", "Lin/etuwa/app/ui/survey/SurveyAdapter;", "getAdapter", "()Lin/etuwa/app/ui/survey/SurveyAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentSurveyBinding;", "flag", "", "getFlag", "()Z", "setFlag", "(Z)V", "i", "", "getI", "()I", "setI", "(I)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "surveyViewModel", "Lin/etuwa/app/ui/survey/SurveyViewModel;", "getSurveyViewModel", "()Lin/etuwa/app/ui/survey/SurveyViewModel;", "surveyViewModel$delegate", "doTheSurvey", "", "id", "", "type", "hideBaseView", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SurveyFragment extends BaseFragment implements SurveyAdapter.SurveyCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentSurveyBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private boolean flag;
    private int i;
    private MainCallBackListener listener;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* renamed from: surveyViewModel$delegate, reason: from kotlin metadata */
    private final Lazy surveyViewModel;

    /* compiled from: SurveyFragment.kt */
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
    public static final SurveyFragment newInstance(Integer num) {
        return INSTANCE.newInstance(num);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public SurveyFragment() {
        final SurveyFragment surveyFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(surveyFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.surveyViewModel = FragmentViewModelLazyKt.createViewModelLazy(surveyFragment, Reflection.getOrCreateKotlinClass(SurveyViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(SurveyViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final SurveyFragment surveyFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SurveyAdapter>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.survey.SurveyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SurveyAdapter invoke() {
                ComponentCallbacks componentCallbacks = surveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SurveyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.survey.SurveyFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = surveyFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final SurveyViewModel getSurveyViewModel() {
        return (SurveyViewModel) this.surveyViewModel.getValue();
    }

    private final SurveyAdapter getAdapter() {
        return (SurveyAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentSurveyBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final int getI() {
        return this.i;
    }

    public final void setI(int i) {
        this.i = i;
    }

    /* compiled from: SurveyFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lin/etuwa/app/ui/survey/SurveyFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/survey/SurveyFragment;", "id", "", "(Ljava/lang/Integer;)Lin/etuwa/app/ui/survey/SurveyFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SurveyFragment newInstance(Integer id) {
            SurveyFragment surveyFragment = new SurveyFragment();
            Bundle bundle = new Bundle();
            Intrinsics.checkNotNull(id);
            bundle.putInt("id", id.intValue());
            surveyFragment.setArguments(bundle);
            return surveyFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.i = arguments.getInt("id");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentSurveyBinding.inflate(inflater, container, false);
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding != null) {
            fragmentSurveyBinding.setSurveyViewModel(getSurveyViewModel());
        }
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null) {
            fragmentSurveyBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
        if (fragmentSurveyBinding3 != null) {
            return fragmentSurveyBinding3.getRoot();
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
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.survey));
        }
        hideBaseView();
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        RecyclerView recyclerView = fragmentSurveyBinding != null ? fragmentSurveyBinding.rvSurvey : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setSurveyCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        getSurveyViewModel().getSurveyList();
        FragmentSurveyBinding fragmentSurveyBinding2 = get_binding();
        if (fragmentSurveyBinding2 != null && (swipeRefreshLayout = fragmentSurveyBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    SurveyFragment.setUp$lambda$1(SurveyFragment.this);
                }
            });
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "asiet", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "demo", false, 2, (Object) null)) {
            FragmentSurveyBinding fragmentSurveyBinding3 = get_binding();
            TextView textView5 = fragmentSurveyBinding3 != null ? fragmentSurveyBinding3.courseBtn : null;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        } else {
            FragmentSurveyBinding fragmentSurveyBinding4 = get_binding();
            TextView textView6 = fragmentSurveyBinding4 != null ? fragmentSurveyBinding4.courseBtn : null;
            if (textView6 != null) {
                textView6.setVisibility(8);
            }
        }
        if (StringsKt.contains$default((CharSequence) getPreference().getBaseUrl(), (CharSequence) "sahrdaya", false, 2, (Object) null)) {
            FragmentSurveyBinding fragmentSurveyBinding5 = get_binding();
            textView = fragmentSurveyBinding5 != null ? fragmentSurveyBinding5.graduateBtn : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            FragmentSurveyBinding fragmentSurveyBinding6 = get_binding();
            textView = fragmentSurveyBinding6 != null ? fragmentSurveyBinding6.graduateBtn : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        FragmentSurveyBinding fragmentSurveyBinding7 = get_binding();
        if (fragmentSurveyBinding7 != null && (textView4 = fragmentSurveyBinding7.courseBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setUp$lambda$2(SurveyFragment.this, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding8 = get_binding();
        if (fragmentSurveyBinding8 != null && (textView3 = fragmentSurveyBinding8.poSurveyBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SurveyFragment.setUp$lambda$3(SurveyFragment.this, view);
                }
            });
        }
        FragmentSurveyBinding fragmentSurveyBinding9 = get_binding();
        if (fragmentSurveyBinding9 == null || (textView2 = fragmentSurveyBinding9.graduateBtn) == null) {
            return;
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SurveyFragment.setUp$lambda$4(SurveyFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(SurveyFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getSurveyViewModel().getSurveyList();
        FragmentSurveyBinding fragmentSurveyBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentSurveyBinding != null ? fragmentSurveyBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.showCourseSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.openPoSurvey();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(SurveyFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainCallBackListener mainCallBackListener = this$0.listener;
        if (mainCallBackListener != null) {
            mainCallBackListener.onGradiateSurveyOpen();
        }
    }

    private final void listenResponse() {
        getSurveyViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.survey.SurveyFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SurveyFragment.listenResponse$lambda$6(SurveyFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$6(SurveyFragment this$0, Resource resource) {
        MainCallBackListener mainCallBackListener;
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
            FragmentSurveyBinding fragmentSurveyBinding = this$0.get_binding();
            if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
                return;
            }
            String message = resource.getMessage();
            Intrinsics.checkNotNull(message);
            ToastExtKt.showErrorToast(recyclerView, message);
            return;
        }
        this$0.hideProgress();
        ArrayList<Survey> arrayList = (ArrayList) resource.getData();
        if (arrayList != null) {
            this$0.showBaseView();
            this$0.getAdapter().addItems(arrayList);
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    break;
                }
                String lowerCase = arrayList.get(i2).getBtnStatus().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                if (!Intrinsics.areEqual(lowerCase, "completed")) {
                    String lowerCase2 = arrayList.get(i2).getBtnStatus().toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    if (!Intrinsics.areEqual(lowerCase2, "last date over")) {
                        this$0.flag = false;
                        break;
                    }
                }
                this$0.flag = true;
                i2++;
            }
            if (this$0.flag && this$0.i == 1 && (mainCallBackListener = this$0.listener) != null) {
                mainCallBackListener.onSurveyFullyCompleted(true, "");
            }
        }
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentSurveyBinding fragmentSurveyBinding = get_binding();
        if (fragmentSurveyBinding == null || (recyclerView = fragmentSurveyBinding.rvSurvey) == null) {
            return;
        }
        RecycleExtKt.hide(recyclerView);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override // in.etuwa.app.ui.survey.SurveyAdapter.SurveyCallBack
    public void doTheSurvey(String id, String type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(type, "type");
        if (Intrinsics.areEqual(type, ExifInterface.GPS_MEASUREMENT_2D)) {
            MainCallBackListener mainCallBackListener = this.listener;
            if (mainCallBackListener != null) {
                mainCallBackListener.doGeneralSurvey(id);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(type, "1")) {
            MainCallBackListener mainCallBackListener2 = this.listener;
            if (mainCallBackListener2 != null) {
                mainCallBackListener2.showTeacherSurveyList(id);
                return;
            }
            return;
        }
        MainCallBackListener mainCallBackListener3 = this.listener;
        if (mainCallBackListener3 != null) {
            mainCallBackListener3.doGeneralSurvey(id);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
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