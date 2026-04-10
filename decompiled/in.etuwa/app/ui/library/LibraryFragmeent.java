package in.etuwa.app.ui.library;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
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
import in.etuwa.app.R;
import in.etuwa.app.data.model.library.BookRecordResponse;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.data.preference.SharedPrefManager;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.library.book.BookAdapter;
import in.etuwa.app.ui.library.book.details.BookDetailsDialog;
import in.etuwa.app.ui.library.suggest.SuggestBookDialog;
import in.etuwa.app.utils.Resource;
import in.etuwa.app.utils.Status;
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

/* JADX INFO: compiled from: LibraryFragmeent.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class LibraryFragmeent extends Fragment implements SuggestBookDialog.SuggestListener, BookAdapter.BooksCallBack, BookRecordAdapter.BooksCallBack, BookDetailsDialog.BooksDetailsListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: adapterBook$delegate, reason: from kotlin metadata */
    private final Lazy adapterBook;

    /* JADX INFO: renamed from: adapterBookRecord$delegate, reason: from kotlin metadata */
    private final Lazy adapterBookRecord;

    /* JADX INFO: renamed from: libraryViewModel$delegate, reason: from kotlin metadata */
    private final Lazy libraryViewModel;
    private MainCallBackListener listener;

    /* JADX INFO: renamed from: preference$delegate, reason: from kotlin metadata */
    private final Lazy preference;

    @JvmStatic
    public static final LibraryFragmeent newInstance() {
        return INSTANCE.newInstance();
    }

    @Override // in.etuwa.app.ui.library.suggest.SuggestBookDialog.SuggestListener
    public void dismiss() {
    }

    public LibraryFragmeent() {
        final LibraryFragmeent libraryFragmeent = this;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.preference = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<SharedPrefManager>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.data.preference.SharedPrefManager, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPrefManager invoke() {
                ComponentCallbacks componentCallbacks = libraryFragmeent;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(SharedPrefManager.class), qualifier, b);
            }
        });
        final LibraryFragmeent libraryFragmeent2 = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return libraryFragmeent2;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(libraryFragmeent2);
        final byte b2 = 0 == true ? 1 : 0;
        final byte b3 = 0 == true ? 1 : 0;
        this.libraryViewModel = FragmentViewModelLazyKt.createViewModelLazy(libraryFragmeent2, Reflection.getOrCreateKotlinClass(LibraryViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(LibraryViewModel.class), b2, b3, null, koinScope);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b4 = 0 == true ? 1 : 0;
        final byte b5 = 0 == true ? 1 : 0;
        this.adapterBookRecord = LazyKt.lazy(lazyThreadSafetyMode2, (Function0) new Function0<BookRecordAdapter>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BookRecordAdapter invoke() {
                ComponentCallbacks componentCallbacks = libraryFragmeent;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BookRecordAdapter.class), b4, b5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode3 = LazyThreadSafetyMode.SYNCHRONIZED;
        final byte b6 = 0 == true ? 1 : 0;
        final byte b7 = 0 == true ? 1 : 0;
        this.adapterBook = LazyKt.lazy(lazyThreadSafetyMode3, (Function0) new Function0<BookAdapter>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v2, types: [in.etuwa.app.ui.library.book.BookAdapter, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function0
            public final BookAdapter invoke() {
                ComponentCallbacks componentCallbacks = libraryFragmeent;
                return AndroidKoinScopeExtKt.getKoinScope(componentCallbacks).get(Reflection.getOrCreateKotlinClass(BookAdapter.class), b6, b7);
            }
        });
    }

    private final SharedPrefManager getPreference() {
        return (SharedPrefManager) this.preference.getValue();
    }

    private final LibraryViewModel getLibraryViewModel() {
        return (LibraryViewModel) this.libraryViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BookRecordAdapter getAdapterBookRecord() {
        return (BookRecordAdapter) this.adapterBookRecord.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BookAdapter getAdapterBook() {
        return (BookAdapter) this.adapterBook.getValue();
    }

    /* JADX INFO: compiled from: LibraryFragmeent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lin/etuwa/app/ui/library/LibraryFragmeent$Companion;", "", "()V", "newInstance", "Lin/etuwa/app/ui/library/LibraryFragmeent;", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final LibraryFragmeent newInstance() {
            return new LibraryFragmeent();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_books);
        final RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_books_records);
        recyclerView.setAdapter(getAdapterBook());
        getAdapterBook().setBooksCallBack2(this);
        recyclerView2.setAdapter(getAdapterBookRecord());
        getAdapterBookRecord().setBooksCallBack2(this);
        getPreference().setNewLogin(false);
        listenResponse();
        listenRecordResponse();
        getLibraryViewModel().getBooksData();
        final TextView textView = (TextView) view.findViewById(R.id.book_btn);
        final TextView textView2 = (TextView) view.findViewById(R.id.book_record_btn);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LibraryFragmeent.onViewCreated$lambda$0(recyclerView, recyclerView2, this, textView, textView2, view2);
                }
            });
        }
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LibraryFragmeent.onViewCreated$lambda$1(recyclerView, recyclerView2, this, textView2, textView, view2);
                }
            });
        }
        TextView textView3 = (TextView) view.findViewById(R.id.suggest_btn);
        if (textView3 != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: in.etuwa.app.ui.library.LibraryFragmeent$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    LibraryFragmeent.onViewCreated$lambda$2(this.f$0, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(RecyclerView recyclerView, RecyclerView recyclerView2, LibraryFragmeent this$0, TextView textView, TextView textView2, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView.setVisibility(0);
        recyclerView2.setVisibility(8);
        this$0.getLibraryViewModel().getBooksData();
        textView.setBackgroundResource(R.drawable.shape_round_selected);
        textView2.setBackgroundResource(R.drawable.shape_round_unselected);
        textView.setTextColor(-1);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(RecyclerView recyclerView, RecyclerView recyclerView2, LibraryFragmeent this$0, TextView textView, TextView textView2, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        recyclerView.setVisibility(8);
        recyclerView2.setVisibility(0);
        this$0.getLibraryViewModel().getBooksRecordData();
        textView.setBackgroundResource(R.drawable.shape_round_selected);
        textView2.setBackgroundResource(R.drawable.shape_round_unselected);
        textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setTextColor(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(LibraryFragmeent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentManager childFragmentManager = this$0.getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        SuggestBookDialog suggestBookDialogNewInstance = SuggestBookDialog.INSTANCE.newInstance();
        suggestBookDialogNewInstance.setCallBack(this$0);
        suggestBookDialogNewInstance.show(childFragmentManager, (String) null);
    }

    private final void listenResponse() {
        getLibraryViewModel().getResponse().observe(getViewLifecycleOwner(), new LibraryFragmeent$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BooksResponse>, Unit>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.library.LibraryFragmeent$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: LibraryFragmeent.kt */
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
                BooksResponse data;
                if (WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()] == 1 && (data = resource.getData()) != null) {
                    LibraryFragmeent.this.getAdapterBook().addItems(data.getBooks());
                }
            }
        }));
    }

    private final void listenRecordResponse() {
        getLibraryViewModel().getRecordResponse().observe(getViewLifecycleOwner(), new LibraryFragmeent$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BookRecordResponse>, Unit>() { // from class: in.etuwa.app.ui.library.LibraryFragmeent.listenRecordResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.library.LibraryFragmeent$listenRecordResponse$1$WhenMappings */
            /* JADX INFO: compiled from: LibraryFragmeent.kt */
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<BookRecordResponse> resource) {
                BookRecordResponse data;
                if (WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()] == 1 && (data = resource.getData()) != null) {
                    LibraryFragmeent.this.getAdapterBookRecord().addItems(data.getBook_record());
                }
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
            return;
        }
        throw new RuntimeException(context + " must implement OnFragmentInteractionListener");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listener = null;
    }

    @Override // in.etuwa.app.ui.library.book.BookAdapter.BooksCallBack
    public void onDetailsBtnClicked(int position) {
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        BookDetailsDialog bookDetailsDialogNewInstance = BookDetailsDialog.INSTANCE.newInstance(position);
        bookDetailsDialogNewInstance.setCallBack2(this);
        bookDetailsDialogNewInstance.show(childFragmentManager, (String) null);
    }
}