package in.etuwa.etlabstaff.ui.library.bookrecord;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.library.BookRecordResponse;
import in.etuwa.app.databinding.FragmentBooksRecordsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
import in.etuwa.app.utils.ToastExtKt;
import in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordAdapter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
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

/* compiled from: BookRecordFragment.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0016J&\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001dH\u0016J\b\u0010,\u001a\u00020\u001dH\u0016J\u001a\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010/\u001a\u00020\u001dH\u0014J\b\u00100\u001a\u00020\u001dH\u0014J\b\u00101\u001a\u00020\u001dH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordFragment;", "Lin/etuwa/app/ui/base/BaseFragment;", "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter$BooksCallBack;", "()V", "_binding", "Lin/etuwa/app/databinding/FragmentBooksRecordsBinding;", "adapter", "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter;", "getAdapter", "()Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "binding", "getBinding", "()Lin/etuwa/app/databinding/FragmentBooksRecordsBinding;", "bookRecordViewModel", "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordViewModel;", "getBookRecordViewModel", "()Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordViewModel;", "bookRecordViewModel$delegate", "hel", "", "getHel", "()Z", "setHel", "(Z)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lin/etuwa/app/helper/MainCallBackListener;", "hideBaseView", "", "hideProgress", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDetach", "onViewCreated", SvgConstants.Tags.VIEW, "setUp", "showBaseView", "showProgress", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BookRecordFragment extends BaseFragment implements BookRecordAdapter.BooksCallBack {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentBooksRecordsBinding _binding;

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: bookRecordViewModel$delegate, reason: from kotlin metadata */
    private final Lazy bookRecordViewModel;
    private boolean hel;
    private MainCallBackListener listener;

    @JvmStatic
    public static final BookRecordFragment newInstance() {
        return INSTANCE.newInstance();
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

    public BookRecordFragment() {
        final BookRecordFragment bookRecordFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(bookRecordFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.bookRecordViewModel = FragmentViewModelLazyKt.createViewModelLazy(bookRecordFragment, Reflection.getOrCreateKotlinClass(BookRecordViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(BookRecordViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final BookRecordFragment bookRecordFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<BookRecordAdapter>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BookRecordAdapter invoke() {
                ComponentCallbacks componentCallbacks = bookRecordFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BookRecordAdapter.class), b2, b3);
            }
        });
    }

    private final BookRecordViewModel getBookRecordViewModel() {
        return (BookRecordViewModel) this.bookRecordViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BookRecordAdapter getAdapter() {
        return (BookRecordAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final FragmentBooksRecordsBinding get_binding() {
        return this._binding;
    }

    public final boolean getHel() {
        return this.hel;
    }

    public final void setHel(boolean z) {
        this.hel = z;
    }

    /* compiled from: BookRecordFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/etlabstaff/ui/library/bookrecord/BookRecordFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BookRecordFragment newInstance() {
            return new BookRecordFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentBooksRecordsBinding.inflate(inflater, container, false);
        FragmentBooksRecordsBinding fragmentBooksRecordsBinding = get_binding();
        if (fragmentBooksRecordsBinding != null) {
            fragmentBooksRecordsBinding.setBookRecordViewModel(getBookRecordViewModel());
        }
        FragmentBooksRecordsBinding fragmentBooksRecordsBinding2 = get_binding();
        if (fragmentBooksRecordsBinding2 != null) {
            fragmentBooksRecordsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentBooksRecordsBinding fragmentBooksRecordsBinding3 = get_binding();
        if (fragmentBooksRecordsBinding3 != null) {
            return fragmentBooksRecordsBinding3.getRoot();
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
        hideBaseView();
        FragmentBooksRecordsBinding fragmentBooksRecordsBinding = get_binding();
        RecyclerView recyclerView = fragmentBooksRecordsBinding != null ? fragmentBooksRecordsBinding.rvBooksRecords : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setBooksCallBack(this);
        getBookRecordViewModel().getBooksData();
        listenResponse();
    }

    private final void listenResponse() {
        getBookRecordViewModel().getResponse().observe(getViewLifecycleOwner(), new BookRecordFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BookRecordResponse>, Unit>() { // from class: in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordFragment$listenResponse$1

            /* compiled from: BookRecordFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends BookRecordResponse> resource) {
                invoke2((Resource<BookRecordResponse>) resource);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<BookRecordResponse> resource) {
                BookRecordAdapter adapter;
                FragmentBooksRecordsBinding fragmentBooksRecordsBinding;
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    BookRecordFragment.this.hideProgress();
                    BookRecordResponse data = resource.getData();
                    if (data != null) {
                        BookRecordFragment bookRecordFragment = BookRecordFragment.this;
                        bookRecordFragment.showBaseView();
                        adapter = bookRecordFragment.getAdapter();
                        adapter.addItems(data.getBook_record());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    BookRecordFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    BookRecordFragment.this.hideProgress();
                    BookRecordFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                BookRecordFragment.this.hideProgress();
                BookRecordFragment.this.showBaseView();
                fragmentBooksRecordsBinding = BookRecordFragment.this.get_binding();
                if (fragmentBooksRecordsBinding == null || (recyclerView = fragmentBooksRecordsBinding.rvBooksRecords) == null) {
                    return;
                }
                String message = resource.getMessage();
                Intrinsics.checkNotNull(message);
                ToastExtKt.showErrorToast(recyclerView, message);
            }
        }));
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

    @Override // androidx.fragment.app.Fragment
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