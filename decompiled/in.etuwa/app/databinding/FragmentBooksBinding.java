package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import in.etuwa.app.R;
import in.etuwa.app.ui.library.book.BookViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentBooksBinding extends ViewDataBinding {
    public final LinearLayout inboxCoordinateLayout;

    @Bindable
    protected BookViewModel mBooksViewModel;
    public final RecyclerView rvBooks;

    public abstract void setBooksViewModel(BookViewModel booksViewModel);

    protected FragmentBooksBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout inboxCoordinateLayout, RecyclerView rvBooks) {
        super(_bindingComponent, _root, _localFieldCount);
        this.inboxCoordinateLayout = inboxCoordinateLayout;
        this.rvBooks = rvBooks;
    }

    public BookViewModel getBooksViewModel() {
        return this.mBooksViewModel;
    }

    public static FragmentBooksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentBooksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_books, root, attachToRoot, component);
    }

    public static FragmentBooksBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentBooksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_books, null, false, component);
    }

    public static FragmentBooksBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksBinding bind(View view, Object component) {
        return (FragmentBooksBinding) bind(component, view, R.layout.fragment_books);
    }
}