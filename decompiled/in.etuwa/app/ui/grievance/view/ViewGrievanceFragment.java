package in.etuwa.app.ui.grievance.view;

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
import in.etuwa.app.R;
import in.etuwa.app.data.model.grievance.view.Actions;
import in.etuwa.app.data.model.grievance.view.GrievanceDoc;
import in.etuwa.app.data.model.grievance.view.ViewGrievanceResponse;
import in.etuwa.app.databinding.ViewGrievanceFragmentBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.grievance.view.actions.ActionsDialog;
import in.etuwa.app.ui.grievance.view.cellmembers.CellMemberDialog;
import in.etuwa.app.ui.grievance.view.doc.GrievanceDocDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
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

/* compiled from: ViewGrievanceFragment.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0014J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\u001a\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010(\u001a\u00020\u0019H\u0014J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0019H\u0014J\b\u0010-\u001a\u00020\u0019H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\r0\u0006j\b\u0012\u0004\u0012\u00020\r`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0006j\b\u0012\u0004\u0012\u00020\u000f`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0006j\b\u0012\u0004\u0012\u00020\u000f`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006/"}, d2 = {"Lin/etuwa/app/ui/grievance/view/ViewGrievanceFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "()V", "_binding", "Lin/etuwa/app/databinding/ViewGrievanceFragmentBinding;", "actions", "Ljava/util/ArrayList;", "Lin/etuwa/app/data/model/grievance/view/Actions;", "Lkotlin/collections/ArrayList;", "binding", "getBinding", "()Lin/etuwa/app/databinding/ViewGrievanceFragmentBinding;", "cellMembers", "", "grDocs", "Lin/etuwa/app/data/model/grievance/view/GrievanceDoc;", "id", "replyDocs", "viewGrievanceViewModel", "Lin/etuwa/app/ui/grievance/view/ViewGrievanceViewModel;", "getViewGrievanceViewModel", "()Lin/etuwa/app/ui/grievance/view/ViewGrievanceViewModel;", "viewGrievanceViewModel$delegate", "Lkotlin/Lazy;", "hideBaseView", "", "hideProgress", "listenResponse", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "setUpViews", "response", "Lin/etuwa/app/data/model/grievance/view/ViewGrievanceResponse;", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ViewGrievanceFragment extends BaseFragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ViewGrievanceFragmentBinding _binding;
    private ArrayList<Actions> actions;
    private ArrayList<String> cellMembers;
    private ArrayList<GrievanceDoc> grDocs;
    private String id;
    private ArrayList<GrievanceDoc> replyDocs;

    /* renamed from: viewGrievanceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewGrievanceViewModel;

    @JvmStatic
    public static final ViewGrievanceFragment newInstance(String str) {
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

    public ViewGrievanceFragment() {
        final ViewGrievanceFragment viewGrievanceFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(viewGrievanceFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.viewGrievanceViewModel = FragmentViewModelLazyKt.createViewModelLazy(viewGrievanceFragment, Reflection.getOrCreateKotlinClass(ViewGrievanceViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(ViewGrievanceViewModel.class), qualifier, b, null, koinScope);
            }
        });
        this.actions = new ArrayList<>();
        this.cellMembers = new ArrayList<>();
        this.grDocs = new ArrayList<>();
        this.replyDocs = new ArrayList<>();
    }

    private final ViewGrievanceViewModel getViewGrievanceViewModel() {
        return (ViewGrievanceViewModel) this.viewGrievanceViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final ViewGrievanceFragmentBinding get_binding() {
        return this._binding;
    }

    /* compiled from: ViewGrievanceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lin/etuwa/app/ui/grievance/view/ViewGrievanceFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/grievance/view/ViewGrievanceFragment;", "id", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final ViewGrievanceFragment newInstance(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            ViewGrievanceFragment viewGrievanceFragment = new ViewGrievanceFragment();
            Bundle bundle = new Bundle();
            bundle.putString("id", id);
            viewGrievanceFragment.setArguments(bundle);
            return viewGrievanceFragment;
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
        this._binding = ViewGrievanceFragmentBinding.inflate(inflater, container, false);
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding = get_binding();
        if (viewGrievanceFragmentBinding != null) {
            viewGrievanceFragmentBinding.setViewGrievanceViewModel(getViewGrievanceViewModel());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding2 = get_binding();
        if (viewGrievanceFragmentBinding2 != null) {
            viewGrievanceFragmentBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding3 = get_binding();
        if (viewGrievanceFragmentBinding3 != null) {
            return viewGrievanceFragmentBinding3.getRoot();
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
            activity.setTitle(getString(R.string.grievance));
        }
        listenResponse();
        getViewGrievanceViewModel().getGrievance(this.id);
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding = get_binding();
        if (viewGrievanceFragmentBinding != null && (swipeRefreshLayout = viewGrievanceFragmentBinding.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ViewGrievanceFragment.setUp$lambda$1(ViewGrievanceFragment.this);
                }
            });
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding2 = get_binding();
        if (viewGrievanceFragmentBinding2 != null && (textView4 = viewGrievanceFragmentBinding2.actionLevelBtn) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewGrievanceFragment.setUp$lambda$2(ViewGrievanceFragment.this, view);
                }
            });
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding3 = get_binding();
        if (viewGrievanceFragmentBinding3 != null && (textView3 = viewGrievanceFragmentBinding3.cellMemberBtn) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewGrievanceFragment.setUp$lambda$3(ViewGrievanceFragment.this, view);
                }
            });
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding4 = get_binding();
        if (viewGrievanceFragmentBinding4 != null && (textView2 = viewGrievanceFragmentBinding4.viewGrDocBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ViewGrievanceFragment.setUp$lambda$4(ViewGrievanceFragment.this, view);
                }
            });
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding5 = get_binding();
        if (viewGrievanceFragmentBinding5 == null || (textView = viewGrievanceFragmentBinding5.viewReplyDocBtn) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ViewGrievanceFragment.setUp$lambda$5(ViewGrievanceFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(ViewGrievanceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getViewGrievanceViewModel().getGrievance(this$0.id);
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = viewGrievanceFragmentBinding != null ? viewGrievanceFragmentBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(ViewGrievanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ActionsDialog.INSTANCE.newInstance(this$0.actions).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$3(ViewGrievanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CellMemberDialog.INSTANCE.newInstance(this$0.cellMembers).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$4(ViewGrievanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrievanceDocDialog.INSTANCE.newInstance(this$0.grDocs, true).show(this$0.getChildFragmentManager(), (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$5(ViewGrievanceFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GrievanceDocDialog.INSTANCE.newInstance(this$0.replyDocs, false).show(this$0.getChildFragmentManager(), (String) null);
    }

    private final void listenResponse() {
        getViewGrievanceViewModel().getResponse().observe(getViewLifecycleOwner(), new ViewGrievanceFragmentKt$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends ViewGrievanceResponse>, Unit>() { // from class: in.etuwa.app.ui.grievance.view.ViewGrievanceFragment$listenResponse$1

            /* compiled from: ViewGrievanceFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends ViewGrievanceResponse> resource) {
                invoke2((Resource<ViewGrievanceResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<ViewGrievanceResponse> resource) {
                ViewGrievanceFragmentBinding viewGrievanceFragmentBinding;
                TextView textView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    ViewGrievanceFragment.this.hideProgress();
                    ViewGrievanceResponse data = resource.getData();
                    if (data != null) {
                        ViewGrievanceFragment viewGrievanceFragment = ViewGrievanceFragment.this;
                        viewGrievanceFragment.showBaseView();
                        viewGrievanceFragment.setUpViews(data);
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    ViewGrievanceFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    ViewGrievanceFragment.this.hideProgress();
                    ViewGrievanceFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                ViewGrievanceFragment.this.hideProgress();
                ViewGrievanceFragment.this.showBaseView();
                viewGrievanceFragmentBinding = ViewGrievanceFragment.this.get_binding();
                if (viewGrievanceFragmentBinding == null || (textView = viewGrievanceFragmentBinding.actionLevelBtn) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(textView, message);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setUpViews(ViewGrievanceResponse response) {
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding = get_binding();
        TextView textView = viewGrievanceFragmentBinding != null ? viewGrievanceFragmentBinding.grNumber : null;
        if (textView != null) {
            textView.setText(response.getGrievance().getGrievanceNo());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding2 = get_binding();
        TextView textView2 = viewGrievanceFragmentBinding2 != null ? viewGrievanceFragmentBinding2.grType : null;
        if (textView2 != null) {
            textView2.setText(response.getGrievance().getGrievanceType());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding3 = get_binding();
        TextView textView3 = viewGrievanceFragmentBinding3 != null ? viewGrievanceFragmentBinding3.grTitle : null;
        if (textView3 != null) {
            textView3.setText(response.getGrievance().getSubject());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding4 = get_binding();
        TextView textView4 = viewGrievanceFragmentBinding4 != null ? viewGrievanceFragmentBinding4.grGrievant : null;
        if (textView4 != null) {
            textView4.setText(response.getGrievance().getGreivant());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding5 = get_binding();
        TextView textView5 = viewGrievanceFragmentBinding5 != null ? viewGrievanceFragmentBinding5.grPostDate : null;
        if (textView5 != null) {
            textView5.setText(response.getGrievance().getDate());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding6 = get_binding();
        TextView textView6 = viewGrievanceFragmentBinding6 != null ? viewGrievanceFragmentBinding6.grDetails : null;
        if (textView6 != null) {
            textView6.setText(response.getGrievance().getDescription());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding7 = get_binding();
        TextView textView7 = viewGrievanceFragmentBinding7 != null ? viewGrievanceFragmentBinding7.grStatus : null;
        if (textView7 != null) {
            textView7.setText(response.getGrievance().getStatus());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding8 = get_binding();
        TextView textView8 = viewGrievanceFragmentBinding8 != null ? viewGrievanceFragmentBinding8.grActionTaken : null;
        if (textView8 != null) {
            textView8.setText(response.getGrievance().getActionTaken());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding9 = get_binding();
        TextView textView9 = viewGrievanceFragmentBinding9 != null ? viewGrievanceFragmentBinding9.grReply : null;
        if (textView9 != null) {
            textView9.setText(response.getGrievance().getReply());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding10 = get_binding();
        TextView textView10 = viewGrievanceFragmentBinding10 != null ? viewGrievanceFragmentBinding10.grDateOfReply : null;
        if (textView10 != null) {
            textView10.setText(response.getGrievance().getReplyDate());
        }
        ViewGrievanceFragmentBinding viewGrievanceFragmentBinding11 = get_binding();
        TextView textView11 = viewGrievanceFragmentBinding11 != null ? viewGrievanceFragmentBinding11.grReplyDetails : null;
        if (textView11 != null) {
            textView11.setText(response.getGrievance().getReplyDetails());
        }
        this.actions.clear();
        this.actions.addAll(response.getActions());
        this.cellMembers.clear();
        this.cellMembers.addAll(response.getCellMembers());
        this.grDocs.clear();
        this.grDocs.addAll(response.getGrievance().getGrDoc());
        this.replyDocs.clear();
        this.replyDocs.addAll(response.getGrievance().getReplyDoc());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}