package in.etuwa.app.ui.counselling.view;

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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.counselling.view.Actions2;
import in.etuwa.app.data.model.counselling.view.ViewCounsellingResponse;
import in.etuwa.app.databinding.ViewCounsellingFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.counselling.view.actions.Actions2Dialog;
import in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: ViewCounsellingFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0016H\u0016J\u001a\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010%\u001a\u00020\u0016H\u0014J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0016H\u0014J\b\u0010*\u001a\u00020\u0016H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006,"}, d2 = {"Lin/etuwa/app/ui/counselling/view/ViewCounsellingFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/ViewCounsellingFragmentBinding;", "actions2", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/counselling/view/Actions2;", "Lkotlin/collections/ArrayList;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ViewCounsellingFragmentBinding;", "cellMembers", "", "id", "viewCounsellingViewModel", "Lin/etuwa/app/ui/counselling/view/ViewCounsellingViewModel;", "getViewCounsellingViewModel", "()Lin/etuwa/app/ui/counselling/view/ViewCounsellingViewModel;", "viewCounsellingViewModel$delegate", "Lkotlin/Lazy;", "hideBaseView", "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setUpViews", "response", "Lin/etuwa/app/data/model/counselling/view/ViewCounsellingResponse;", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ViewCounsellingFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ViewCounsellingFragmentBinding _binding;
    private ArrayList<Actions2> actions2;
    private ArrayList<String> cellMembers;
    private String id;

    /* renamed from: viewCounsellingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewCounsellingViewModel;

    @JvmStatic
    public static final ViewCounsellingFragment newInstance(String str) {
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

    public ViewCounsellingFragment() {
        final ViewCounsellingFragment viewCounsellingFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewCounsellingFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewCounsellingViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewCounsellingFragment, Reflection.getOrCreateKotlinClass(ViewCounsellingViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewCounsellingViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.actions2 = new ArrayList<>();
        this.cellMembers = new ArrayList<>();
    }

    private final ViewCounsellingViewModel getViewCounsellingViewModel() {
        return (ViewCounsellingViewModel) this.viewCounsellingViewModel.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final ViewCounsellingFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ViewCounsellingFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/counselling/view/ViewCounsellingFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/counselling/view/ViewCounsellingFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewCounsellingFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ViewCounsellingFragment viewCounsellingFragment = new ViewCounsellingFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            viewCounsellingFragment.setArguments(bundle);
            return viewCounsellingFragment;
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
        this._binding = ViewCounsellingFragmentBinding.inflate(inflater, container, false);
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding = get_binding();
        if (viewCounsellingFragmentBinding != null) {
            viewCounsellingFragmentBinding.setViewCounsellingViewModel(getViewCounsellingViewModel());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding2 = get_binding();
        if (viewCounsellingFragmentBinding2 != null) {
            viewCounsellingFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding3 = get_binding();
        if (viewCounsellingFragmentBinding3 != null) {
            return viewCounsellingFragmentBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle("View Counselling");
        }
        listenResponse();
        getViewCounsellingViewModel().getCounselling(this.id);
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding = get_binding();
        if (viewCounsellingFragmentBinding != null && (swipeRefreshLayout = viewCounsellingFragmentBinding.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ViewCounsellingFragment.setUp$lambda$1(ViewCounsellingFragment.this);
                }
            });
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding2 = get_binding();
        if (viewCounsellingFragmentBinding2 != null && (textView2 = viewCounsellingFragmentBinding2.cellMemberBtncs) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewCounsellingFragment.setUp$lambda$2(ViewCounsellingFragment.this, view);
                }
            });
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding3 = get_binding();
        if (viewCounsellingFragmentBinding3 == null || (textView = viewCounsellingFragmentBinding3.action2LevelBtncs) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewCounsellingFragment.setUp$lambda$3(ViewCounsellingFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ViewCounsellingFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewCounsellingViewModel().getCounselling(this$0.id);
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = viewCounsellingFragmentBinding != null ? viewCounsellingFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ViewCounsellingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CellMemberDialog.INSTANCE.newInstance(this$0.cellMembers).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ViewCounsellingFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Actions2Dialog.INSTANCE.newInstance(this$0.actions2).show(this$0.getChildFragmentManager(), (String) null);
    }

    private final void listenResponse() {
        getViewCounsellingViewModel().getResponse().observe(getViewLifecycleOwner(), new ViewCounsellingFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewCounsellingResponse>, Unit>() { // from class: in.etuwa.app.ui.counselling.view.ViewCounsellingFragment$listenResponse$1

            /* compiled from: ViewCounsellingFragment.kt */
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

            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewCounsellingResponse> resource) {
                invoke2((Resource<ViewCounsellingResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewCounsellingResponse> resource) {
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ViewCounsellingFragment.this.hideProgress();
                    ViewCounsellingResponse data = resource.getData();
                    if (data != null) {
                        ViewCounsellingFragment viewCounsellingFragment = ViewCounsellingFragment.this;
                        viewCounsellingFragment.showBaseView();
                        viewCounsellingFragment.setUpViews(data);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ViewCounsellingFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ViewCounsellingFragment.this.hideProgress();
                    ViewCounsellingFragment.this.showBaseView();
                } else {
                    if (i != 4) {
                        return;
                    }
                    ViewCounsellingFragment.this.hideProgress();
                    ViewCounsellingFragment.this.showBaseView();
                }
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpViews(ViewCounsellingResponse response) {
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding = get_binding();
        TextView textView = viewCounsellingFragmentBinding != null ? viewCounsellingFragmentBinding.csNumber : null;
        if (textView != null) {
            textView.setText(response.getRequests().getId());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding2 = get_binding();
        TextView textView2 = viewCounsellingFragmentBinding2 != null ? viewCounsellingFragmentBinding2.csType : null;
        if (textView2 != null) {
            textView2.setText(response.getRequests().getCounsellingType());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding3 = get_binding();
        TextView textView3 = viewCounsellingFragmentBinding3 != null ? viewCounsellingFragmentBinding3.csApplicant : null;
        if (textView3 != null) {
            textView3.setText(response.getRequests().getApplicant());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding4 = get_binding();
        TextView textView4 = viewCounsellingFragmentBinding4 != null ? viewCounsellingFragmentBinding4.csDate : null;
        if (textView4 != null) {
            textView4.setText(response.getRequests().getDate());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding5 = get_binding();
        TextView textView5 = viewCounsellingFragmentBinding5 != null ? viewCounsellingFragmentBinding5.csConcern : null;
        if (textView5 != null) {
            textView5.setText(response.getRequests().getConcern());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding6 = get_binding();
        TextView textView6 = viewCounsellingFragmentBinding6 != null ? viewCounsellingFragmentBinding6.csImpactHome : null;
        if (textView6 != null) {
            textView6.setText(response.getRequests().getImpactHome());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding7 = get_binding();
        TextView textView7 = viewCounsellingFragmentBinding7 != null ? viewCounsellingFragmentBinding7.csImpactStudies : null;
        if (textView7 != null) {
            textView7.setText(response.getRequests().getImpactStudies());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding8 = get_binding();
        TextView textView8 = viewCounsellingFragmentBinding8 != null ? viewCounsellingFragmentBinding8.csImpactRelationship : null;
        if (textView8 != null) {
            textView8.setText(response.getRequests().getImpactRelationship());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding9 = get_binding();
        TextView textView9 = viewCounsellingFragmentBinding9 != null ? viewCounsellingFragmentBinding9.csPhysicallyEmotionally : null;
        if (textView9 != null) {
            textView9.setText(response.getRequests().getImpactPhysicallyEmotionally());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding10 = get_binding();
        TextView textView10 = viewCounsellingFragmentBinding10 != null ? viewCounsellingFragmentBinding10.csCounsellingHistory : null;
        if (textView10 != null) {
            textView10.setText(response.getRequests().getCounsellingHistory());
        }
        ViewCounsellingFragmentBinding viewCounsellingFragmentBinding11 = get_binding();
        TextView textView11 = viewCounsellingFragmentBinding11 != null ? viewCounsellingFragmentBinding11.csCounsellingSessionRequired : null;
        if (textView11 != null) {
            textView11.setText(response.getRequests().getCounsellingSessionRequired());
        }
        this.actions2.clear();
        this.actions2.addAll(response.getActions());
        this.cellMembers.clear();
        this.cellMembers.addAll(response.getCellMembers());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}