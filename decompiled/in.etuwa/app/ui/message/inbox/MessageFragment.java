package in.etuwa.app.ui.message.inbox;

import android.content.ComponentCallbacks;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.protocol.HTTP;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.R;
import in.etuwa.app.data.model.SuccessResponse;
import in.etuwa.app.data.model.message.Inbox;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.databinding.FragmentMessageBinding;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.message.inbox.InboxAdapter;
import in.etuwa.app.ui.message.reply.ReplyDialog;
import in.etuwa.app.utils.RecycleExtKt;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import java.util.ArrayList;
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
import kotlin.text.StringsKt;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* compiled from: MessageFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u001aH\u0014J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010&\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u001aH\u0016J\b\u00100\u001a\u00020\u001aH\u0016J\u0018\u00101\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u00020)2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00104\u001a\u00020\u001aH\u0014J\b\u00105\u001a\u00020\u001aH\u0014J\b\u00106\u001a\u00020\u001aH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017¨\u00068"}, d2 = {"Lin/etuwa/app/ui/message/inbox/MessageFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/app/ui/message/inbox/InboxAdapter$CallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentMessageBinding;", "adapter", "Lin/etuwa/app/ui/message/inbox/InboxAdapter;", "getAdapter", "()Lin/etuwa/app/ui/message/inbox/InboxAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentMessageBinding;", "messageViewModel", "Lin/etuwa/app/ui/message/inbox/MessageViewModel;", "getMessageViewModel", "()Lin/etuwa/app/ui/message/inbox/MessageViewModel;", "messageViewModel$delegate", "preference", "Lin/etuwa/app/data/preference/SharedPrefManager;", "getPreference", "()Lin/etuwa/app/data/preference/SharedPrefManager;", "preference$delegate", "hideBaseView", "", "hideProgress", "listenDeleteResponse", "listenResponse", "loadReplyDialog", "id", "", NotificationCompat.CATEGORY_MESSAGE, "Lin/etuwa/app/data/model/message/Inbox;", "onCreateOptionsMenu", CommonCssConstants.MENU, "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onReadClick", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MessageFragment extends BaseFragment implements InboxAdapter.CallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentMessageBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: messageViewModel$delegate, reason: from kotlin metadata */
    private final Lazy messageViewModel;

    /* renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    /* compiled from: MessageFragment.kt */
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
    public static final MessageFragment newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showProgress() {
    }

    public MessageFragment() {
        final MessageFragment messageFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(messageFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.messageViewModel = FragmentViewModelLazyKt.createViewModelLazy(messageFragment, Reflection.getOrCreateKotlinClass(MessageViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(MessageViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final MessageFragment messageFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<InboxAdapter>() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.message.inbox.InboxAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final InboxAdapter invoke() {
                ComponentCallbacks componentCallbacks = messageFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(InboxAdapter.class), b2, b3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = messageFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), b4, b5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageViewModel getMessageViewModel() {
        return (MessageViewModel) this.messageViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InboxAdapter getAdapter() {
        return (InboxAdapter) this.adapter.getValue();
    }

    /* renamed from: getBinding, reason: from getter */
    private final FragmentMessageBinding get_binding() {
        return this._binding;
    }

    /* compiled from: MessageFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/message/inbox/MessageFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/message/inbox/MessageFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MessageFragment newInstance() {
            return new MessageFragment();
        }
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentMessageBinding.inflate(inflater, container, false);
        FragmentMessageBinding fragmentMessageBinding = get_binding();
        if (fragmentMessageBinding != null) {
            fragmentMessageBinding.setMessageViewModel(getMessageViewModel());
        }
        FragmentMessageBinding fragmentMessageBinding2 = get_binding();
        if (fragmentMessageBinding2 != null) {
            fragmentMessageBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentMessageBinding fragmentMessageBinding3 = get_binding();
        if (fragmentMessageBinding3 != null) {
            return fragmentMessageBinding3.getRoot();
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
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setTitle(getString(R.string.inbox));
        }
        setHasOptionsMenu(true);
        hideBaseView();
        FragmentMessageBinding fragmentMessageBinding = get_binding();
        RecyclerView recyclerView = fragmentMessageBinding != null ? fragmentMessageBinding.rvInbox : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setCallBack(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenDeleteResponse();
        FragmentMessageBinding fragmentMessageBinding2 = get_binding();
        if (fragmentMessageBinding2 != null && (swipeRefreshLayout = fragmentMessageBinding2.swipeLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$$ExternalSyntheticLambda2
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    MessageFragment.setUp$lambda$0(MessageFragment.this);
                }
            });
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new MessageFragment$setUp$swipeHandler$1(this, requireContext()));
        FragmentMessageBinding fragmentMessageBinding3 = get_binding();
        itemTouchHelper.attachToRecyclerView(fragmentMessageBinding3 != null ? fragmentMessageBinding3.rvInbox : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setUp$lambda$0(MessageFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getMessageViewModel().getInboxMsg();
        FragmentMessageBinding fragmentMessageBinding = this$0.get_binding();
        SwipeRefreshLayout swipeRefreshLayout = fragmentMessageBinding != null ? fragmentMessageBinding.swipeLayout : null;
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
        inflater.inflate(R.menu.msg_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private final void listenResponse() {
        getMessageViewModel().getInboxResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageFragment.listenResponse$lambda$2(MessageFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenResponse$lambda$2(MessageFragment this$0, Resource resource) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
        if (i == 1) {
            this$0.hideProgress();
            ArrayList<Inbox> arrayList = (ArrayList) resource.getData();
            if (arrayList != null) {
                this$0.showBaseView();
                this$0.getAdapter().addItems(arrayList);
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
        FragmentMessageBinding fragmentMessageBinding = this$0.get_binding();
        if (fragmentMessageBinding == null || (recyclerView = fragmentMessageBinding.rvInbox) == null) {
            return;
        }
        String message = resource.getMessage();
        Intrinsics.checkNotNull(message);
        ToastExtKt.showErrorToast(recyclerView, message);
    }

    private final void listenDeleteResponse() {
        getMessageViewModel().getDeleteResponse().observe(getViewLifecycleOwner(), new Observer() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$$ExternalSyntheticLambda3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MessageFragment.listenDeleteResponse$lambda$4(MessageFragment.this, (Resource) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void listenDeleteResponse$lambda$4(MessageFragment this$0, Resource resource) {
        RecyclerView rvInbox;
        RecyclerView rvInbox2;
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
            FragmentMessageBinding fragmentMessageBinding = this$0.get_binding();
            if (fragmentMessageBinding == null || (recyclerView = fragmentMessageBinding.rvInbox) == null) {
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
                    FragmentMessageBinding fragmentMessageBinding2 = this$0.get_binding();
                    if (fragmentMessageBinding2 != null && (rvInbox2 = fragmentMessageBinding2.rvInbox) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvInbox2, "rvInbox");
                        ToastExtKt.showSuccessToast(rvInbox2, successResponse.getMessage());
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    FragmentMessageBinding fragmentMessageBinding3 = this$0.get_binding();
                    if (fragmentMessageBinding3 != null && (rvInbox = fragmentMessageBinding3.rvInbox) != null) {
                        Intrinsics.checkNotNullExpressionValue(rvInbox, "rvInbox");
                        ToastExtKt.showErrorToast(rvInbox, successResponse.getMessage());
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
            } catch (Exception unused) {
                Unit unit3 = Unit.INSTANCE;
            }
        }
    }

    @Override // in.etuwa.app.ui.message.inbox.InboxAdapter.CallBack
    public void onReadClick(final String id, final Inbox msg) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(msg, "msg");
        getMessageViewModel().readMsg(id);
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("From : " + StringsKt.capitalize(msg.getFrom()));
        builder.setMessage(msg.getContent());
        builder.setPositiveButton("Reply", new DialogInterface.OnClickListener() { // from class: in.etuwa.app.ui.message.inbox.MessageFragment$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MessageFragment.onReadClick$lambda$5(MessageFragment.this, id, msg, dialogInterface, i);
            }
        });
        builder.setNegativeButton(HTTP.CONN_CLOSE, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReadClick$lambda$5(MessageFragment this$0, String id, Inbox msg, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(id, "$id");
        Intrinsics.checkNotNullParameter(msg, "$msg");
        Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
        this$0.loadReplyDialog(id, msg);
    }

    private final void loadReplyDialog(String id, Inbox msg) {
        ReplyDialog.INSTANCE.newInstance(id, msg.getSenderId(), msg.getFrom()).show(getChildFragmentManager(), (String) null);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void showBaseView() {
        RecyclerView recyclerView;
        FragmentMessageBinding fragmentMessageBinding = get_binding();
        if (fragmentMessageBinding == null || (recyclerView = fragmentMessageBinding.rvInbox) == null) {
            return;
        }
        RecycleExtKt.show(recyclerView);
    }

    @Override // in.etuwa.app.ui.base.BaseFragment
    protected void hideBaseView() {
        RecyclerView recyclerView;
        FragmentMessageBinding fragmentMessageBinding = get_binding();
        if (fragmentMessageBinding == null || (recyclerView = fragmentMessageBinding.rvInbox) == null) {
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