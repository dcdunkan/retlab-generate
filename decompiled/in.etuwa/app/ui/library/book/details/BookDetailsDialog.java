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

/* compiled from: BookDetailsDialog.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 02\u00020\u0001:\u0002/0B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\b\u0010%\u001a\u00020\u0016H\u0016J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020\u001f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020,J\b\u0010-\u001a\u00020\u0016H\u0014J\b\u0010.\u001a\u00020\u0016H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014¨\u00061"}, d2 = {"Lin/etuwa/app/ui/library/book/details/BookDetailsDialog;", "Lin/etuwa/app/ui/base/BaseDialog;", "()V", "_binding", "Lin/etuwa/app/databinding/DialogBooksDetailsBinding;", "binding", "getBinding", "()Lin/etuwa/app/databinding/DialogBooksDetailsBinding;", "booksDetailsViewModel", "Lin/etuwa/app/ui/library/book/details/BookDetailsViewModel;", "getBooksDetailsViewModel", "()Lin/etuwa/app/ui/library/book/details/BookDetailsViewModel;", "booksDetailsViewModel$delegate", "Lkotlin/Lazy;", "listner", "Lin/etuwa/app/ui/library/book/details/BookDetailsDialog$BooksDetailsListener;", "listner2", "Lin/etuwa/app/helper/MainCallBackListener;", CommonCssConstants.POSITION, "", "Ljava/lang/Integer;", "hideProgress", "", "listenResponse", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onDetach", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onViewCreated", SvgConstants.Tags.VIEW, "setCallBack", "Lin/etuwa/app/ui/library/book/BookFragment;", "setUp", "showProgress", "BooksDetailsListener", "Companion", "app_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BookDetailsDialog extends BaseDialog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private DialogBooksDetailsBinding _binding;

    /* renamed from: booksDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy booksDetailsViewModel;
    private BooksDetailsListener listner;
    private MainCallBackListener listner2;
    private Integer position;

    /* compiled from: BookDetailsDialog.kt */
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
                return Fragment.this;
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
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
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
                return GetViewModelFactoryKt.getViewModelFactory((ViewModelStoreOwner) Function0.this.invoke(), Reflection.getOrCreateKotlinClass(BookDetailsViewModel.class), qualifier, b, null, koinScope);
            }
        });
    }

    private final BookDetailsViewModel getBooksDetailsViewModel() {
        return (BookDetailsViewModel) this.booksDetailsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getBinding, reason: from getter */
    public final DialogBooksDetailsBinding get_binding() {
        return this._binding;
    }

    /* compiled from: BookDetailsDialog.kt */
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
        getBooksDetailsViewModel().getResponse().observe(getViewLifecycleOwner(), new BookDetailsDialog$sam$androidx_lifecycle_Observer$0(new Function1<Resource<? extends BooksResponse>, Unit>() { // from class: in.etuwa.app.ui.library.book.details.BookDetailsDialog$listenResponse$1

            /* compiled from: BookDetailsDialog.kt */
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

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Resource<BooksResponse> resource) {
                DialogBooksDetailsBinding dialogBooksDetailsBinding;
                DialogBooksDetailsBinding dialogBooksDetailsBinding2;
                DialogBooksDetailsBinding dialogBooksDetailsBinding3;
                DialogBooksDetailsBinding dialogBooksDetailsBinding4;
                DialogBooksDetailsBinding dialogBooksDetailsBinding5;
                DialogBooksDetailsBinding dialogBooksDetailsBinding6;
                DialogBooksDetailsBinding dialogBooksDetailsBinding7;
                DialogBooksDetailsBinding dialogBooksDetailsBinding8;
                DialogBooksDetailsBinding dialogBooksDetailsBinding9;
                DialogBooksDetailsBinding dialogBooksDetailsBinding10;
                DialogBooksDetailsBinding dialogBooksDetailsBinding11;
                TextView textView;
                Integer num;
                TextView textView2;
                Integer num2;
                TextView textView3;
                Integer num3;
                TextView textView4;
                Integer num4;
                TextView textView5;
                Integer num5;
                TextView textView6;
                Integer num6;
                TextView textView7;
                Integer num7;
                TextView textView8;
                Integer num8;
                TextView textView9;
                Integer num9;
                TextView textView10;
                Integer num10;
                TextView textView11;
                Integer num11;
                DialogBooksDetailsBinding dialogBooksDetailsBinding12;
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
                    dialogBooksDetailsBinding12 = BookDetailsDialog.this.get_binding();
                    if (dialogBooksDetailsBinding12 == null || (textView12 = dialogBooksDetailsBinding12.bookId) == null) {
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
                    dialogBooksDetailsBinding = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding != null && (textView11 = dialogBooksDetailsBinding.bookId) != null) {
                        ArrayList<Books> books = data.getBooks();
                        num11 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num11);
                        textView11.setText(books.get(num11.intValue()).getBookid());
                    }
                    dialogBooksDetailsBinding2 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding2 != null && (textView10 = dialogBooksDetailsBinding2.bookNo) != null) {
                        ArrayList<Books> books2 = data.getBooks();
                        num10 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num10);
                        textView10.setText(books2.get(num10.intValue()).getSlno());
                    }
                    dialogBooksDetailsBinding3 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding3 != null && (textView9 = dialogBooksDetailsBinding3.bookTitle) != null) {
                        ArrayList<Books> books3 = data.getBooks();
                        num9 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num9);
                        textView9.setText(books3.get(num9.intValue()).getTitle());
                    }
                    dialogBooksDetailsBinding4 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding4 != null && (textView8 = dialogBooksDetailsBinding4.booksAuthor) != null) {
                        ArrayList<Books> books4 = data.getBooks();
                        num8 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num8);
                        textView8.setText(books4.get(num8.intValue()).getAuthor());
                    }
                    dialogBooksDetailsBinding5 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding5 != null && (textView7 = dialogBooksDetailsBinding5.bookType) != null) {
                        ArrayList<Books> books5 = data.getBooks();
                        num7 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num7);
                        textView7.setText(books5.get(num7.intValue()).getName());
                    }
                    dialogBooksDetailsBinding6 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding6 != null && (textView6 = dialogBooksDetailsBinding6.booksCategory) != null) {
                        ArrayList<Books> books6 = data.getBooks();
                        num6 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num6);
                        textView6.setText(books6.get(num6.intValue()).getCategory());
                    }
                    dialogBooksDetailsBinding7 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding7 != null && (textView5 = dialogBooksDetailsBinding7.booksDistribution) != null) {
                        ArrayList<Books> books7 = data.getBooks();
                        num5 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num5);
                        textView5.setText(books7.get(num5.intValue()).getDistribution());
                    }
                    dialogBooksDetailsBinding8 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding8 != null && (textView4 = dialogBooksDetailsBinding8.booksEdition) != null) {
                        ArrayList<Books> books8 = data.getBooks();
                        num4 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num4);
                        textView4.setText(books8.get(num4.intValue()).getEdition());
                    }
                    dialogBooksDetailsBinding9 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding9 != null && (textView3 = dialogBooksDetailsBinding9.booksIsbn) != null) {
                        ArrayList<Books> books9 = data.getBooks();
                        num3 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num3);
                        textView3.setText(books9.get(num3.intValue()).getIsbn());
                    }
                    dialogBooksDetailsBinding10 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding10 != null && (textView2 = dialogBooksDetailsBinding10.booksLocation) != null) {
                        ArrayList<Books> books10 = data.getBooks();
                        num2 = bookDetailsDialog.position;
                        Intrinsics.checkNotNull(num2);
                        textView2.setText(books10.get(num2.intValue()).getLocation());
                    }
                    dialogBooksDetailsBinding11 = bookDetailsDialog.get_binding();
                    if (dialogBooksDetailsBinding11 == null || (textView = dialogBooksDetailsBinding11.booksStatus) == null) {
                        return;
                    }
                    ArrayList<Books> books11 = data.getBooks();
                    num = bookDetailsDialog.position;
                    Intrinsics.checkNotNull(num);
                    textView.setText(books11.get(num.intValue()).getStatus());
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

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }
}