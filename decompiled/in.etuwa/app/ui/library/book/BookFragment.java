package in.etuwa.app.ui.library.book;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.databinding.FragmentBooksBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseFragment;
import in.etuwa.app.ui.library.book.BookAdapter;
import in.etuwa.app.ui.library.book.details.BookDetailsDialog;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.ext.android.GetViewModelFactoryKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

/* JADX INFO: compiled from: BookFragment.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class BookFragment extends BaseFragment implements BookAdapter.BooksCallBack, BookDetailsDialog.BooksDetailsListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private FragmentBooksBinding _binding;

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: booksViewModel$delegate, reason: from kotlin metadata */
    private final Lazy booksViewModel;
    private boolean hel;
    private MainCallBackListener listener;

    @JvmStatic
    public static final BookFragment newInstance() {
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

    public BookFragment() {
        final BookFragment bookFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.library.book.BookFragment$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return bookFragment;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(bookFragment);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.booksViewModel = FragmentViewModelLazyKt.createViewModelLazy(bookFragment, Reflection.getOrCreateKotlinClass(BookViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.library.book.BookFragment$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.library.book.BookFragment$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(BookViewModel.class), qualifier, b, null, koinScope);
            }
        });
        final BookFragment bookFragment2 = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.adapter = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<BookAdapter>() { // from class: in.etuwa.app.ui.library.book.BookFragment$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.library.book.BookAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BookAdapter invoke() {
                ComponentCallbacks componentCallbacks = bookFragment2;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BookAdapter.class), b2, b3);
            }
        });
    }

    private final BookViewModel getBooksViewModel() {
        return (BookViewModel) this.booksViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BookAdapter getAdapter() {
        return (BookAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final FragmentBooksBinding get_binding() {
        return this._binding;
    }

    public final boolean getHel() {
        return this.hel;
    }

    public final void setHel(boolean z) {
        this.hel = z;
    }

    /* JADX INFO: compiled from: BookFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/library/book/BookFragment$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/library/book/BookFragment;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BookFragment newInstance() {
            return new BookFragment();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = FragmentBooksBinding.inflate(inflater, container, false);
        FragmentBooksBinding fragmentBooksBinding = get_binding();
        if (fragmentBooksBinding != null) {
            fragmentBooksBinding.setBooksViewModel(getBooksViewModel());
        }
        FragmentBooksBinding fragmentBooksBinding2 = get_binding();
        if (fragmentBooksBinding2 != null) {
            fragmentBooksBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        FragmentBooksBinding fragmentBooksBinding3 = get_binding();
        if (fragmentBooksBinding3 != null) {
            return fragmentBooksBinding3.getRoot();
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
        FragmentBooksBinding fragmentBooksBinding = get_binding();
        RecyclerView recyclerView = fragmentBooksBinding != null ? fragmentBooksBinding.rvBooks : null;
        if (recyclerView != null) {
            recyclerView.setAdapter(getAdapter());
        }
        getAdapter().setBooksCallBack(this);
        getBooksViewModel().getBooksData();
        listenResponse();
    }

    private final void listenResponse() {
        getBooksViewModel().getResponse().observe(getViewLifecycleOwner(), new BookFragment$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BooksResponse>, Unit>() { // from class: in.etuwa.app.ui.library.book.BookFragment.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.library.book.BookFragment$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: BookFragment.kt */
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
            public /* bridge */ /* synthetic */ Unit invoke(Resource<? extends BooksResponse> resource) {
                invoke2((Resource<BooksResponse>) resource);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<BooksResponse> resource) {
                RecyclerView recyclerView;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i == 1) {
                    BookFragment.this.hideProgress();
                    BooksResponse data = resource.getData();
                    if (data != null) {
                        BookFragment bookFragment = BookFragment.this;
                        bookFragment.showBaseView();
                        bookFragment.getAdapter().addItems(data.getBooks());
                        return;
                    }
                    return;
                }
                if (i == 2) {
                    BookFragment.this.showProgress();
                    return;
                }
                if (i == 3) {
                    BookFragment.this.hideProgress();
                    BookFragment.this.showBaseView();
                    return;
                }
                if (i != 4) {
                    return;
                }
                BookFragment.this.hideProgress();
                BookFragment.this.showBaseView();
                FragmentBooksBinding fragmentBooksBinding = BookFragment.this.get_binding();
                if (fragmentBooksBinding == null || (recyclerView = fragmentBooksBinding.rvBooks) == null) {
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

    @Override // in.etuwa.app.ui.library.book.BookAdapter.BooksCallBack
    public void onDetailsBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        BookDetailsDialog bookDetailsDialogNewInstance = BookDetailsDialog.INSTANCE.newInstance(position);
        bookDetailsDialogNewInstance.setCallBack(this);
        bookDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }
}