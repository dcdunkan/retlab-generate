package in.etuwa.app.ui.library.book.details;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.itextpdf.styledxmlparser.css.CommonCssConstants;
import com.itextpdf.svg.SvgConstants;
import in.etuwa.app.data.model.library.Books;
import in.etuwa.app.data.model.library.BooksResponse;
import in.etuwa.app.databinding.DialogBooksDetailsBinding;
import in.etuwa.app.helper.MainCallBackListener;
import in.etuwa.app.ui.base.BaseDialog;
import in.etuwa.app.ui.library.LibraryFragmeent;
import in.etuwa.app.ui.library.book.BookFragment;
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

/* JADX INFO: compiled from: BookDetailsDialog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class BookDetailsDialog extends BaseDialog {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogBooksDetailsBinding _binding;

    /* JADX INFO: renamed from: booksDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy booksDetailsViewModel;
    private BooksDetailsListener listner;
    private MainCallBackListener listner2;
    private Integer position;

    /* JADX INFO: compiled from: BookDetailsDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lin/etuwa/app/ui/library/book/details/BookDetailsDialog$BooksDetailsListener;", "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface BooksDetailsListener {
    }

    @JvmStatic
    public static final BookDetailsDialog newInstance(int i) {
        return INSTANCE.newInstance(i);
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void hideProgress() {
    }

    @Override // in.etuwa.app.ui.base.BaseDialog
    protected void showProgress() {
    }

    public BookDetailsDialog() {
        final BookDetailsDialog bookDetailsDialog = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsDialog$special$$inlined$viewModel$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return bookDetailsDialog;
            }
        };
        final Scope koinScope = AndroidKoinScopeExtKt.getKoinScope(bookDetailsDialog);
        final Qualifier qualifier = null;
        final byte b = 0 == true ? 1 : 0;
        this.booksDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(bookDetailsDialog, Reflection.getOrCreateKotlinClass(BookDetailsViewModel.class), new Function0<ViewModelStore>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsDialog$special$$inlined$viewModel$default$3
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsDialog$special$$inlined$viewModel$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) function0.invoke(), Reflection.getOrCreateKotlinClass(BookDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final BookDetailsViewModel getBooksDetailsViewModel() {
        return (BookDetailsViewModel) this.booksDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getBinding, reason: from getter */
    public final DialogBooksDetailsBinding get_binding() {
        return this._binding;
    }

    /* JADX INFO: compiled from: BookDetailsDialog.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lin/etuwa/app/ui/library/book/details/BookDetailsDialog$Companion;", "Landroid/content/DialogInterface;", "()V", "cancel", "", "dismiss", "newInstance", "Lin/etuwa/app/ui/library/book/details/BookDetailsDialog;", CommonCssConstants.POSITION, "", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements DialogInterface {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // android.content.DialogInterface
        public void cancel() {
        }

        @Override // android.content.DialogInterface
        public void dismiss() {
        }

        private Companion() {
        }

        @JvmStatic
        public final BookDetailsDialog newInstance(int position) {
            BookDetailsDialog bookDetailsDialog = new BookDetailsDialog();
            Bundle bundle = new Bundle();
            bundle.putInt("flag", position);
            bookDetailsDialog.setArguments(bundle);
            return bookDetailsDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.position = Integer.valueOf(arguments.getInt("flag"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = DialogBooksDetailsBinding.inflate(inflater, container, false);
        DialogBooksDetailsBinding dialogBooksDetailsBinding = get_binding();
        if (dialogBooksDetailsBinding != null) {
            dialogBooksDetailsBinding.setBooksDetailsViewModel(getBooksDetailsViewModel());
        }
        DialogBooksDetailsBinding dialogBooksDetailsBinding2 = get_binding();
        if (dialogBooksDetailsBinding2 != null) {
            dialogBooksDetailsBinding2.setLifecycleOwner(getViewLifecycleOwner());
        }
        DialogBooksDetailsBinding dialogBooksDetailsBinding3 = get_binding();
        if (dialogBooksDetailsBinding3 != null) {
            return dialogBooksDetailsBinding3.getRoot();
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
        listenResponse();
        getBooksDetailsViewModel().getBooksData();
    }

    private final void listenResponse() {
        getBooksDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new BookDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BooksResponse>, Unit>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsDialog.listenResponse.1

            /* JADX INFO: renamed from: in.etuwa.app.ui.library.book.details.BookDetailsDialog$listenResponse$1$WhenMappings */
            /* JADX INFO: compiled from: BookDetailsDialog.kt */
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
                TextView textView;
                TextView textView2;
                TextView textView3;
                TextView textView4;
                TextView textView5;
                TextView textView6;
                TextView textView7;
                TextView textView8;
                TextView textView9;
                TextView textView10;
                TextView textView11;
                TextView textView12;
                int i = WhenMappings.$EnumSwitchMapping$0[resource.getStatus().ordinal()];
                if (i != 1) {
                    if (i == 2) {
                        BookDetailsDialog.this.showProgress();
                        return;
                    }
                    if (i == 3) {
                        BookDetailsDialog.this.hideProgress();
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    BookDetailsDialog.this.hideProgress();
                    DialogBooksDetailsBinding dialogBooksDetailsBinding = BookDetailsDialog.this.get_binding();
                    if (dialogBooksDetailsBinding == null || (textView12 = dialogBooksDetailsBinding.bookId) == null) {
                        return;
                    }
                    String message = resource.getMessage();
                    Intrinsics.checkNotNull(message);
                    ToastExtKt.showErrorToast(textView12, message);
                    return;
                }
                BookDetailsDialog.this.hideProgress();
                BooksResponse data = resource.getData();
                if (data != null) {
                    BookDetailsDialog bookDetailsDialog = BookDetailsDialog.this;
                    DialogBooksDetailsBinding dialogBooksDetailsBinding2 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding2 != null && (textView11 = dialogBooksDetailsBinding2.bookId) != null) {
                        ArrayList<Books> books = data.getBooks();
                        Integer num = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num);
                        textView11.setText(books.get(num.intValue()).getBookid());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding3 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding3 != null && (textView10 = dialogBooksDetailsBinding3.bookNo) != null) {
                        ArrayList<Books> books2 = data.getBooks();
                        Integer num2 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num2);
                        textView10.setText(books2.get(num2.intValue()).getSlno());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding4 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding4 != null && (textView9 = dialogBooksDetailsBinding4.bookTitle) != null) {
                        ArrayList<Books> books3 = data.getBooks();
                        Integer num3 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num3);
                        textView9.setText(books3.get(num3.intValue()).getTitle());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding5 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding5 != null && (textView8 = dialogBooksDetailsBinding5.booksAuthor) != null) {
                        ArrayList<Books> books4 = data.getBooks();
                        Integer num4 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num4);
                        textView8.setText(books4.get(num4.intValue()).getAuthor());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding6 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding6 != null && (textView7 = dialogBooksDetailsBinding6.bookType) != null) {
                        ArrayList<Books> books5 = data.getBooks();
                        Integer num5 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num5);
                        textView7.setText(books5.get(num5.intValue()).getName());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding7 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding7 != null && (textView6 = dialogBooksDetailsBinding7.booksCategory) != null) {
                        ArrayList<Books> books6 = data.getBooks();
                        Integer num6 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num6);
                        textView6.setText(books6.get(num6.intValue()).getCategory());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding8 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding8 != null && (textView5 = dialogBooksDetailsBinding8.booksDistribution) != null) {
                        ArrayList<Books> books7 = data.getBooks();
                        Integer num7 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num7);
                        textView5.setText(books7.get(num7.intValue()).getDistribution());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding9 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding9 != null && (textView4 = dialogBooksDetailsBinding9.booksEdition) != null) {
                        ArrayList<Books> books8 = data.getBooks();
                        Integer num8 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num8);
                        textView4.setText(books8.get(num8.intValue()).getEdition());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding10 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding10 != null && (textView3 = dialogBooksDetailsBinding10.booksIsbn) != null) {
                        ArrayList<Books> books9 = data.getBooks();
                        Integer num9 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num9);
                        textView3.setText(books9.get(num9.intValue()).getIsbn());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding11 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding11 != null && (textView2 = dialogBooksDetailsBinding11.booksLocation) != null) {
                        ArrayList<Books> books10 = data.getBooks();
                        Integer num10 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num10);
                        textView2.setText(books10.get(num10.intValue()).getLocation());
                    }
                    DialogBooksDetailsBinding dialogBooksDetailsBinding12 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding12 == null || (textView = dialogBooksDetailsBinding12.booksStatus) == null) {
                        return;
                    }
                    ArrayList<Books> books11 = data.getBooks();
                    Integer num11 = bookDetailsDialog.position;
                    Intrinsics.checkNotNull(num11);
                    textView.setText(books11.get(num11.intValue()).getStatus());
                }
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context instanceof MainCallBackListener) {
            this.listner2 = (MainCallBackListener) context;
        } else {
            super.onAttach(context);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.listner2 = null;
    }

    public final void setCallBack(BookFragment context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listner = context;
    }

    public final void setCallBack2(LibraryFragmeent context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.listner = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}