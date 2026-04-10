package in.etuwa.app.ui.chat.reply;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.cookie.ClientCookie;
import com.itextpdf.svg.SvgConstants;
import de.hdodenhof.circleimageview.CircleImageView;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.CommentReplyDialogBinding;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.chat.comment.CommentDialog;
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

/* JADX INFO: compiled from: CommentReplyDialog.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommentReplyDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private CommentReplyDialogBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: commentReplyDialogViewModel$delegate, reason: from kotlin metadata */
    private final Lazy commentReplyDialogViewModel;
    private OnReplyDialogInteractionListener listener;
    private String paramComment;
    private String paramCommentId;
    private String paramImg;
    private String paramName;
    private String paramSubId;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* JADX INFO: compiled from: CommentReplyDialog.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lin/etuwa/app/ui/chat/reply/CommentReplyDialog$OnReplyDialogInteractionListener;", "", "onReplyDismiss", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface OnReplyDialogInteractionListener {
        void onReplyDismiss();
    }

    /* JADX INFO: compiled from: CommentReplyDialog.kt */
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
    public static final CommentReplyDialog newInstance(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.newInstance(str, str2, str3, str4, str5);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public CommentReplyDialog() {
        final CommentReplyDialog commentReplyDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return commentReplyDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(commentReplyDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.commentReplyDialogViewModel = FragmentViewModelLazyKt.createViewModelLazy(commentReplyDialog, Reflection.getOrCreateKotlinClass(CommentReplyDialogViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(CommentReplyDialogViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final CommentReplyDialog commentReplyDialog2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<CommentReplyAdapter>() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.chat.reply.CommentReplyAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final CommentReplyAdapter invoke() {
                ComponentCallbacks componentCallbacks = commentReplyDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(CommentReplyAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = commentReplyDialog2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    private final CommentReplyDialogViewModel getCommentReplyDialogViewModel() {
        return (CommentReplyDialogViewModel) this.commentReplyDialogViewModel.getValue();
    }

    private final CommentReplyAdapter getAdapter() {
        return (CommentReplyAdapter) this.adapter.getValue();
    }

    /* JADX INFO: renamed from: getBinding, reason: from getter */
    private final CommentReplyDialogBinding get_binding() {
        return this._binding;
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    /* JADX INFO: compiled from: CommentReplyDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u000b"}, d2 = {"Lin/etuwa/app/ui/chat/reply/CommentReplyDialog$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/chat/reply/CommentReplyDialog;", "img", "", "name", ClientCookie.COMMENT_ATTR, "commentId", StoreFragmentKt.SUB_ID, "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CommentReplyDialog newInstance(String img, String name, String comment, String commentId, String subId) {
            Intrinsics.checkNotNullParameter(img, "img");
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(commentId, "commentId");
            CommentReplyDialog commentReplyDialog = new CommentReplyDialog();
            Bundle bundle = new Bundle();
            bundle.putString(CommentReplyDialogKt.ARG_IMG, img);
            bundle.putString(CommentReplyDialogKt.ARG_NAME, name);
            bundle.putString(CommentReplyDialogKt.ARG_COMMENT, comment);
            bundle.putString(CommentReplyDialogKt.ARG_COMMENT_ID, commentId);
            bundle.putString(CommentReplyDialogKt.ARG_SUB_ID, subId);
            commentReplyDialog.setArguments(bundle);
            return commentReplyDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.paramImg = arguments.getString(CommentReplyDialogKt.ARG_IMG);
            this.paramName = arguments.getString(CommentReplyDialogKt.ARG_NAME);
            this.paramComment = arguments.getString(CommentReplyDialogKt.ARG_COMMENT);
            this.paramCommentId = arguments.getString(CommentReplyDialogKt.ARG_COMMENT_ID);
            this.paramSubId = arguments.getString(CommentReplyDialogKt.ARG_SUB_ID);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = CommentReplyDialogBinding.inflate(inflater, container, false);
        CommentReplyDialogBinding commentReplyDialogBinding = get_binding();
        if (commentReplyDialogBinding != null) {
            commentReplyDialogBinding.setCommentReplyDialogViewModel(getCommentReplyDialogViewModel());
        }
        CommentReplyDialogBinding commentReplyDialogBinding2 = get_binding();
        if (commentReplyDialogBinding2 != null) {
            commentReplyDialogBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        CommentReplyDialogBinding commentReplyDialogBinding3 = get_binding();
        if (commentReplyDialogBinding3 != null) {
            return commentReplyDialogBinding3.getRoot();
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
        ImageButton imageButton;
        SwipeRefreshLayout swipeRefreshLayout;
        RecyclerView recyclerView;
        CommentReplyDialogBinding commentReplyDialogBinding = get_binding();
        if (commentReplyDialogBinding != null && (recyclerView = commentReplyDialogBinding.rvReply) != null) {
            RecycleExtKt.hide(recyclerView);
        }
        CommentReplyDialogBinding commentReplyDialogBinding2 = get_binding();
        RecyclerView recyclerView2 = commentReplyDialogBinding2 != null ? commentReplyDialogBinding2.rvReply : null;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(getAdapter());
        }
        RequestBuilder<Drawable> requestBuilderLoad = Glide.with(requireContext()).load(this.paramImg);
        CommentReplyDialogBinding commentReplyDialogBinding3 = get_binding();
        CircleImageView circleImageView = commentReplyDialogBinding3 != null ? commentReplyDialogBinding3.replyCommentUserImg : null;
        Intrinsics.checkNotNull(circleImageView);
        requestBuilderLoad.into(circleImageView);
        CommentReplyDialogBinding commentReplyDialogBinding4 = get_binding();
        TextView textView = commentReplyDialogBinding4 != null ? commentReplyDialogBinding4.replyCommentUserName : null;
        if (textView != null) {
            textView.setText(this.paramName);
        }
        CommentReplyDialogBinding commentReplyDialogBinding5 = get_binding();
        TextView textView2 = commentReplyDialogBinding5 != null ? commentReplyDialogBinding5.replyCommentText : null;
        if (textView2 != null) {
            textView2.setText(this.paramComment);
        }
        listenResponse();
        listenReplyResponse();
        if (Intrinsics.areEqual(getPreference().getUserType(), "0")) {
            getCommentReplyDialogViewModel().getReply(this.paramSubId, this.paramCommentId);
        } else {
            getCommentReplyDialogViewModel().getParentReply(getPreference().getBatchId(), this.paramCommentId);
        }
        CommentReplyDialogBinding commentReplyDialogBinding6 = get_binding();
        if (commentReplyDialogBinding6 != null && (swipeRefreshLayout = commentReplyDialogBinding6.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    CommentReplyDialog.setUp$lambda$1(this.f$0);
                }
            });
        }
        CommentReplyDialogBinding commentReplyDialogBinding7 = get_binding();
        if (commentReplyDialogBinding7 == null || (imageButton = commentReplyDialogBinding7.replyBtnSend) == null) {
            return;
        }
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommentReplyDialog.setUp$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$1(CommentReplyDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
            this$0.getCommentReplyDialogViewModel().getReply(this$0.paramSubId, this$0.paramCommentId);
        } else {
            this$0.getCommentReplyDialogViewModel().getParentReply(this$0.getPreference().getBatchId(), this$0.paramCommentId);
        }
        CommentReplyDialogBinding commentReplyDialogBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = commentReplyDialogBinding != null ? commentReplyDialogBinding.swipeLayout : null;
        if (swipeRefreshLayout == null) {
            return;
        }
        swipeRefreshLayout.setRefreshing(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$2(CommentReplyDialog this$0, View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CommentReplyDialogBinding commentReplyDialogBinding = this$0.get_binding();
        Editable text = null;
        if (Intrinsics.areEqual(String.valueOf((commentReplyDialogBinding == null || (editText3 = commentReplyDialogBinding.etReplyMsg) == null) ? null : editText3.getText()), "")) {
            return;
        }
        if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
            CommentReplyDialogViewModel commentReplyDialogViewModel = this$0.getCommentReplyDialogViewModel();
            String str = this$0.paramSubId;
            String batchId = this$0.getPreference().getBatchId();
            String userSemId = this$0.getPreference().getUserSemId();
            String str2 = this$0.paramCommentId;
            CommentReplyDialogBinding commentReplyDialogBinding2 = this$0.get_binding();
            if (commentReplyDialogBinding2 != null && (editText2 = commentReplyDialogBinding2.etReplyMsg) != null) {
                text = editText2.getText();
            }
            commentReplyDialogViewModel.setReply(str, batchId, userSemId, str2, String.valueOf(text));
            return;
        }
        CommentReplyDialogViewModel commentReplyDialogViewModel2 = this$0.getCommentReplyDialogViewModel();
        String batchId2 = this$0.getPreference().getBatchId();
        String userSemId2 = this$0.getPreference().getUserSemId();
        String str3 = this$0.paramCommentId;
        CommentReplyDialogBinding commentReplyDialogBinding3 = this$0.get_binding();
        if (commentReplyDialogBinding3 != null && (editText = commentReplyDialogBinding3.etReplyMsg) != null) {
            text = editText.getText();
        }
        commentReplyDialogViewModel2.setParentReply(batchId2, userSemId2, str3, String.valueOf(text));
    }

    private final void listenResponse() {
        getCommentReplyDialogViewModel().getResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentReplyDialog.listenResponse$lambda$4(this.f$0, (Resource) obj);
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
    public static final void listenResponse$lambda$4(in.etuwa.app.ui.chat.reply.CommentReplyDialog r3, in.etuwa.app.utils.Resource r4) {
        /*
            java.lang.String r0 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            in.etuwa.app.utils.Status r0 = r4.getStatus()
            int[] r1 = in.etuwa.app.ui.chat.reply.CommentReplyDialog.WhenMappings.$EnumSwitchMapping$0
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
            in.etuwa.app.databinding.CommentReplyDialogBinding r0 = r3.get_binding()
            if (r0 == 0) goto L2f
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvReply
            if (r0 == 0) goto L2f
            in.etuwa.app.utils.RecycleExtKt.show(r0)
        L2f:
            in.etuwa.app.databinding.CommentReplyDialogBinding r3 = r3.get_binding()
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvReply
            if (r3 == 0) goto Lc6
            android.view.View r3 = (android.view.View) r3
            java.lang.String r4 = r4.getMessage()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            in.etuwa.app.utils.ToastExtKt.showErrorToast(r3, r4)
            goto Lc6
        L47:
            r3.hideProgress()
            in.etuwa.app.databinding.CommentReplyDialogBinding r3 = r3.get_binding()
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvReply
            if (r3 == 0) goto Lc6
            in.etuwa.app.utils.RecycleExtKt.show(r3)
            goto Lc6
        L58:
            r3.showProgress()
            goto Lc6
        L5c:
            r3.hideProgress()
            java.lang.Object r4 = r4.getData()
            in.etuwa.app.data.model.chat.reply.ReplyResponse r4 = (in.etuwa.app.data.model.chat.reply.ReplyResponse) r4
            if (r4 == 0) goto Lc6
            in.etuwa.app.databinding.CommentReplyDialogBinding r0 = r3.get_binding()
            java.lang.String r1 = "rvReply"
            if (r0 == 0) goto L79
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvReply
            if (r0 == 0) goto L79
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            in.etuwa.app.utils.RecycleExtKt.show(r0)
        L79:
            boolean r0 = r4.getLogin()     // Catch: java.lang.Exception -> Lc4
            if (r0 == 0) goto Lab
            in.etuwa.app.ui.chat.reply.CommentReplyAdapter r0 = r3.getAdapter()     // Catch: java.lang.Exception -> Lc4
            android.content.Context r1 = r3.requireContext()     // Catch: java.lang.Exception -> Lc4
            java.lang.String r2 = "requireContext()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch: java.lang.Exception -> Lc4
            java.util.ArrayList r2 = r4.getReply()     // Catch: java.lang.Exception -> Lc4
            r0.addItems(r1, r2)     // Catch: java.lang.Exception -> Lc4
            in.etuwa.app.databinding.CommentReplyDialogBinding r3 = r3.get_binding()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvReply     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            java.util.ArrayList r4 = r4.getReply()     // Catch: java.lang.Exception -> Lc4
            int r4 = r4.size()     // Catch: java.lang.Exception -> Lc4
            r3.smoothScrollToPosition(r4)     // Catch: java.lang.Exception -> Lc4
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Lc4
            goto Lc6
        Lab:
            in.etuwa.app.databinding.CommentReplyDialogBinding r3 = r3.get_binding()     // Catch: java.lang.Exception -> Lc4
            if (r3 == 0) goto Lc6
            androidx.recyclerview.widget.RecyclerView r3 = r3.rvReply     // Catch: java.lang.Exception -> Lc4
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
        throw new UnsupportedOperationException("Method not decompiled: in.etuwa.app.ui.chat.reply.CommentReplyDialog.listenResponse$lambda$4(in.etuwa.app.ui.chat.reply.CommentReplyDialog, in.etuwa.app.utils.Resource):void");
    }

    private final void listenReplyResponse() {
        getCommentReplyDialogViewModel().getCommentResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.chat.reply.CommentReplyDialog$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CommentReplyDialog.listenReplyResponse$lambda$6(this.f$0, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenReplyResponse$lambda$6(CommentReplyDialog this$0, Resource resource) {
        RecyclerView rvReply;
        EditText editText;
        RecyclerView rvReply2;
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
            CommentReplyDialogBinding commentReplyDialogBinding = this$0.get_binding();
            if (commentReplyDialogBinding == null || (recyclerView = commentReplyDialogBinding.rvReply) == null) {
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
                    CommentReplyDialogBinding commentReplyDialogBinding2 = this$0.get_binding();
                    if (commentReplyDialogBinding2 != null && (rvReply2 = commentReplyDialogBinding2.rvReply) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvReply2, "rvReply");
                        ToastExtKt.showSuccessToast(rvReply2, successResponse.getMessage());
                    }
                    CommentReplyDialogBinding commentReplyDialogBinding3 = this$0.get_binding();
                    if (commentReplyDialogBinding3 != null && (editText = commentReplyDialogBinding3.etReplyMsg) != null) {
                        editText.setText("");
                    }
                    if (Intrinsics.areEqual(this$0.getPreference().getUserType(), "0")) {
                        this$0.getCommentReplyDialogViewModel().getReply(this$0.paramSubId, this$0.paramCommentId);
                    } else {
                        this$0.getCommentReplyDialogViewModel().getParentReply(this$0.getPreference().getBatchId(), this$0.paramCommentId);
                    }
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                CommentReplyDialogBinding commentReplyDialogBinding4 = this$0.get_binding();
                if (commentReplyDialogBinding4 == null || (rvReply = commentReplyDialogBinding4.rvReply) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(rvReply, "rvReply");
                ToastExtKt.showErrorToast(rvReply, successResponse.getError());
                Unit unit2 = Unit.INSTANCE;
            } catch (Exception unused) {
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    public final void setCallBack(CommentDialog context) {
        this.listener = context;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        OnReplyDialogInteractionListener onReplyDialogInteractionListener = this.listener;
        if (onReplyDialogInteractionListener != null) {
            onReplyDialogInteractionListener.onReplyDismiss();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}