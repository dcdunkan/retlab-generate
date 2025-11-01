package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.library.book.details.BookDetailsViewModel;

/* loaded from: classes3.dex */
public abstract class DialogBooksDetailsBinding extends ViewDataBinding {
    public final TextView artsPayableLbl;
    public final TextView bookId;
    public final TextView bookNo;
    public final TextView bookTitle;
    public final TextView bookType;
    public final TextView booksAuthor;
    public final TextView booksCategory;
    public final TextView booksDistribution;
    public final TextView booksEdition;
    public final TextView booksIsbn;
    public final TextView booksLocation;
    public final TextView booksStatus;

    @Bindable
    protected BookDetailsViewModel mBooksDetailsViewModel;

    public abstract void setBooksDetailsViewModel(BookDetailsViewModel booksDetailsViewModel);

    protected DialogBooksDetailsBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView artsPayableLbl, TextView bookId, TextView bookNo, TextView bookTitle, TextView bookType, TextView booksAuthor, TextView booksCategory, TextView booksDistribution, TextView booksEdition, TextView booksIsbn, TextView booksLocation, TextView booksStatus) {
        super(_bindingComponent, _root, _localFieldCount);
        this.artsPayableLbl = artsPayableLbl;
        this.bookId = bookId;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.bookType = bookType;
        this.booksAuthor = booksAuthor;
        this.booksCategory = booksCategory;
        this.booksDistribution = booksDistribution;
        this.booksEdition = booksEdition;
        this.booksIsbn = booksIsbn;
        this.booksLocation = booksLocation;
        this.booksStatus = booksStatus;
    }

    public BookDetailsViewModel getBooksDetailsViewModel() {
        return this.mBooksDetailsViewModel;
    }

    public static DialogBooksDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBooksDetailsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogBooksDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_books_details, root, attachToRoot, component);
    }

    public static DialogBooksDetailsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBooksDetailsBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogBooksDetailsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_books_details, null, false, component);
    }

    public static DialogBooksDetailsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogBooksDetailsBinding bind(View view, Object component) {
        return (DialogBooksDetailsBinding) bind(component, view, R.layout.dialog_books_details);
    }
}