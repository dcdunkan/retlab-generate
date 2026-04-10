package in.etuwa.app.ui.chat.comment;

import android.content.ComponentCallbacks;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.CommentDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.chat.comment.CommentAdapter;
import in.etuwa.app.ui.chat.reply.CommentReplyDialog;
import in.etuwa.app.ui.store.storeview.StoreFragmentKt;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: CommentDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommentDialog extends BaseDialog implements CommentAdapter.CommentInteract, CommentReplyDialog.OnReplyDialogInteractionListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CommentDialogBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;
    private String batchId;

    /* JADX INFO: renamed from: commentDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy commentDialogViewModel;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;
    private String sem;
    private String subId;

    /* JADX INFO: compiled from: CommentDialog.kt */
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
    public static final CommentDialog newInstance() {
        return INSTANCE.newInstance();
    }

    @JvmStatic
    public static final CommentDialog newInstance(String str, String str2, String str3) {
        return INSTANCE.newInstance(str, str2, str3);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public CommentDialog() {
        final CommentDialog commentDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return commentDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(commentDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.commentDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(commentDialog, Reflection.getOrCreateKotlinClass(CommentDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(CommentDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CommentDialog commentDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommentAdapter>() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.chat.comment.CommentAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CommentAdapter invoke() {
                ComponentCallbacks componentCallbacks = commentDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CommentAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = commentDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CommentDialogViewModel getCommentDialogViewModel() {
        return (CommentDialogViewModel) this.commentDialogViewModel.getValue();
    }

    private final CommentAdapter getAdapter() {
        return (CommentAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final CommentDialogBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: CommentDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lin/etuwa/app/ui/chat/comment/CommentDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/chat/comment/CommentDialog;", "batchId", "", StoreFragmentKt.SUB_ID, "sem", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommentDialog newInstance(String batchId, String subId, String sem) {
            Intrinsics.checkNotNullParameter(batchId, "batchId");
            Intrinsics.checkNotNullParameter(subId, "subId");
            Intrinsics.checkNotNullParameter(sem, "sem");
            CommentDialog commentDialog = new CommentDialog();
            Bundle bundle = new Bundle();
            bundle.putString("sub", subId);
            bundle.putString("batch", batchId);
            bundle.putString("sem", sem);
            commentDialog.setArguments(bundle);
            return commentDialog;
        }

        @JvmStatic
        public final CommentDialog newInstance() {
            return new CommentDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.subId = arguments.getString("sub");
            this.batchId = arguments.getString("batch");
            this.sem = arguments.getString("sem");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CommentDialogBinding.inflate(inflater, container, false);
        CommentDialogBinding commentDialogBinding = get_binding();
        if (commentDialogBinding != null) {
            commentDialogBinding.setCommentDialogViewModel(getCommentDialogViewModel());
        }
        CommentDialogBinding commentDialogBinding2 = get_binding();
        if (commentDialogBinding2 != null) {
            commentDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CommentDialogBinding commentDialogBinding3 = get_binding();
        if (commentDialogBinding3 != null) {
            return commentDialogBinding3.getRoot();
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
        SwipeRefreshLayout swipeRefreshLayout;
        ImageButton imageButton;
        RecyclerView recyclerView;
        CommentDialogBinding commentDialogBinding = get_binding();
        if (commentDialogBinding != null && (recyclerView = commentDialogBinding.rvComment) != null) {
            RecycleExtKt.hide(recyclerView);
        }
        CommentDialogBinding commentDialogBinding2 = get_binding();
        RecyclerView recyclerView2 = commentDialogBinding2 != null ? commentDialogBinding2.rvComment : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        listenResponse();
        listenCommentResponse();
        if (Intrinsics.areEqual(getPreference().getUserType(), "0")) {
            getCommentDialogViewModel().getComment(this.subId);
        } else {
            getCommentDialogViewModel().getParentComment(getPreference().getBatchId());
        }
        CommentDialogBinding commentDialogBinding3 = get_binding();
        if (commentDialogBinding3 != null && (imageButton = commentDialogBinding3.btnSend) != null) {
            imageButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommentDialog.setUp$lambda$1(this.f$0, view);
                }
            });
        }
        CommentDialogBinding commentDialogBinding4 = get_binding();
        if (commentDialogBinding4 == null || (swipeRefreshLayout = commentDialogBinding4.swipeLayout) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$$ExternalSyntheticLambda2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                CommentDialog.setUp$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CommentDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommentDialogBinding commentDialogBinding = this$0.get_binding();
        Editable text = null;
        if (Intrinsics.areEqual(String.valueOf((commentDialogBinding == null || (editText3 = commentDialogBinding.etCommentMsg) == null) ? null : editText3.getText()), "")) {
            return;
        }
        if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
            CommentDialogViewModel commentDialogViewModel = this$0.getCommentDialogViewModel();
            String str = this$0.subId;
            String str2 = this$0.batchId;
            String str3 = this$0.sem;
            CommentDialogBinding commentDialogBinding2 = this$0.get_binding();
            if (commentDialogBinding2 != null && (editText2 = commentDialogBinding2.etCommentMsg) != null) {
                text = editText2.getText();
            }
            commentDialogViewModel.setComment(str, str2, str3, String.valueOf(text));
            return;
        }
        CommentDialogViewModel commentDialogViewModel2 = this$0.getCommentDialogViewModel();
        String batchId = this$0.getPreference().getBatchId();
        String userSemId = this$0.getPreference().getUserSemId();
        CommentDialogBinding commentDialogBinding3 = this$0.get_binding();
        if (commentDialogBinding3 != null && (editText = commentDialogBinding3.etCommentMsg) != null) {
            text = editText.getText();
        }
        commentDialogViewModel2.setParentComment(batchId, userSemId, String.valueOf(text));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(CommentDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
            this$0.getCommentDialogViewModel().getComment(this$0.subId);
        } else {
            this$0.getCommentDialogViewModel().getParentComment(this$0.getPreference().getBatchId());
        }
        CommentDialogBinding commentDialogBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = commentDialogBinding != null ? commentDialogBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    private final void listenResponse() {
        getCommentDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentDialog.listenResponse$lambda$4(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:47:0x00c4
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static final void listenResponse$lambda$4(in.etuwa.app.ui.chat.comment.CommentDialog r3, in.etuwa.app.utils.Resource r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            in.etuwa.app.utils.Status r0 = r4.getStatus()
            int[] r1 = in.etuwa.app.ui.chat.comment.CommentDialog.WhenMappings.$EnumSwitchMapping$0
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 1
            if (r0 == r1) goto L5c
            r1 = 2
            if (r0 == r1) goto L58
            r1 = 3
            if (r0 == r1) goto L47
            r1 = 4
            if (r0 == r1) goto L1f
            goto Lc6
        L1f:
            r3.hideProgress()
            in.etuwa.app.databinding.CommentDialogBinding r0 = r3.get_binding()
            if (r0 == 0) goto L2f
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvComment
            if (r0 == 0) goto L2f
            in.etuwa.app.utils.RecycleExtKt.show(r0)
        L2f:
            in.etuwa.app.databinding.CommentDialogBinding r3 = r3.get_binding()
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvComment
            if (r3 == 0) goto Lc6
            android.view.View r3 = (android.view.View) r3
            java.lang.String r4 = r4.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            in.etuwa.app.utils.ToastExtKt.showErrorToast(r3, r4)
            goto Lc6
        L47:
            r3.hideProgress()
            in.etuwa.app.databinding.CommentDialogBinding r3 = r3.get_binding()
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvComment
            if (r3 == 0) goto Lc6
            in.etuwa.app.utils.RecycleExtKt.show(r3)
            goto Lc6
        L58:
            r3.showProgress()
            goto Lc6
        L5c:
            r3.hideProgress()
            java.lang.Object r4 = r4.getData()
            in.etuwa.app.data.model.chat.comment.CommentResponse r4 = (in.etuwa.app.data.model.chat.comment.CommentResponse) r4
            if (r4 == 0) goto Lc6
            in.etuwa.app.databinding.CommentDialogBinding r0 = r3.get_binding()
            java.lang.String r1 = "rvComment"
            if (r0 == 0) goto L79
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvComment
            if (r0 == 0) goto L79
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            in.etuwa.app.utils.RecycleExtKt.show(r0)
        L79:
            boolean r0 = r4.getLogin()     // Catch: java.lang.Exception -> Lc4
            if (r0 == 0) goto Lab
            in.etuwa.app.ui.chat.comment.CommentAdapter r0 = r3.getAdapter()     // Catch: java.lang.Exception -> Lc4
            android.content.Context r1 = r3.requireContext()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r2 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> Lc4
            java.util.ArrayList r2 = r4.getComments()     // Catch: java.lang.Exception -> Lc4
            r0.addItems(r1, r2)     // Catch: java.lang.Exception -> Lc4
            in.etuwa.app.databinding.CommentDialogBinding r3 = r3.get_binding()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvComment     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            java.util.ArrayList r4 = r4.getComments()     // Catch: java.lang.Exception -> Lc4
            int r4 = r4.size()     // Catch: java.lang.Exception -> Lc4
            r3.smoothScrollToPosition(r4)     // Catch: java.lang.Exception -> Lc4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lc4
            goto Lc6
        Lab:
            in.etuwa.app.databinding.CommentDialogBinding r3 = r3.get_binding()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvComment     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch: java.lang.Exception -> Lc4
            android.view.View r3 = (android.view.View) r3     // Catch: java.lang.Exception -> Lc4
            java.lang.String r4 = r4.getError()     // Catch: java.lang.Exception -> Lc4
            in.etuwa.app.utils.ToastExtKt.showErrorToast(r3, r4)     // Catch: java.lang.Exception -> Lc4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lc4
            goto Lc6
        Lc4:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
        Lc6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.chat.comment.CommentDialog.listenResponse$lambda$4(in.etuwa.app.ui.chat.comment.CommentDialog, in.etuwa.app.utils.Resource):void");
    }

    private final void listenCommentResponse() {
        getCommentDialogViewModel().getCommentResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.chat.comment.CommentDialog$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentDialog.listenCommentResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenCommentResponse$lambda$6(CommentDialog this$0, Resource resource) {
        RecyclerView rvComment;
        EditText editText;
        RecyclerView rvComment2;
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
            CommentDialogBinding commentDialogBinding = this$0.get_binding();
            if (commentDialogBinding == null || (recyclerView = commentDialogBinding.rvComment) == null) {
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
            try {
                if (successResponse.getLogin() && successResponse.getSuccess()) {
                    CommentDialogBinding commentDialogBinding2 = this$0.get_binding();
                    if (commentDialogBinding2 != null && (rvComment2 = commentDialogBinding2.rvComment) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvComment2, "rvComment");
                        ToastExtKt.showSuccessToast(rvComment2, successResponse.getMessage());
                    }
                    CommentDialogBinding commentDialogBinding3 = this$0.get_binding();
                    if (commentDialogBinding3 != null && (editText = commentDialogBinding3.etCommentMsg) != null) {
                        editText.setText("");
                    }
                    if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
                        this$0.getCommentDialogViewModel().getComment(this$0.subId);
                    } else {
                        this$0.getCommentDialogViewModel().getParentComment(this$0.getPreference().getBatchId());
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                CommentDialogBinding commentDialogBinding4 = this$0.get_binding();
                if (commentDialogBinding4 == null || (rvComment = commentDialogBinding4.rvComment) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvComment, "rvComment");
                ToastExtKt.showErrorToast(rvComment, successResponse.getError());
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception unused) {
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    @Override // in.etuwa.app.ui.chat.comment.CommentAdapter.CommentInteract
    public void onOpenReplyDialog(String img, String name, String txt, String comntId) {
        Intrinsics.checkNotNullParameter(img, "img");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(txt, "txt");
        Intrinsics.checkNotNullParameter(comntId, "comntId");
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        CommentReplyDialog commentReplyDialogNewInstance = CommentReplyDialog.INSTANCE.newInstance(img, name, txt, comntId, this.subId);
        commentReplyDialogNewInstance.setCallBack(this);
        commentReplyDialogNewInstance.show(childFragmentManager, (String) null);
    }

    @Override // in.etuwa.app.ui.chat.reply.CommentReplyDialog.OnReplyDialogInteractionListener
    public void onReplyDismiss() {
        if (Intrinsics.areEqual(getPreference().getUserType(), "0")) {
            getCommentDialogViewModel().getComment(this.subId);
        } else {
            getCommentDialogViewModel().getParentComment(getPreference().getBatchId());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
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