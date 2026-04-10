package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class RowLibraryBooksBinding implements ViewBinding {
    public final TextView bookCategory;
    public final TextView bookNo;
    public final TextView bookStatus;
    public final TextView bookTitle;
    public final TextView bookType;
    public final TextView booksAuthor;
    public final TextView booksLocation;
    public final MaterialCardView linearLibraryBooks;
    private final MaterialCardView rootView;

    private RowLibraryBooksBinding(MaterialCardView rootView, TextView bookCategory, TextView bookNo, TextView bookStatus, TextView bookTitle, TextView bookType, TextView booksAuthor, TextView booksLocation, MaterialCardView linearLibraryBooks) {
        this.rootView = rootView;
        this.bookCategory = bookCategory;
        this.bookNo = bookNo;
        this.bookStatus = bookStatus;
        this.bookTitle = bookTitle;
        this.bookType = bookType;
        this.booksAuthor = booksAuthor;
        this.booksLocation = booksLocation;
        this.linearLibraryBooks = linearLibraryBooks;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowLibraryBooksBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowLibraryBooksBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_library_books, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowLibraryBooksBinding bind(View rootView) {
        int i = R.id.book_category;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.book_no;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.book_status;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.book_title;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.book_type;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.books_author;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.books_location;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    MaterialCardView materialCardView = (MaterialCardView) rootView;
                                    return new RowLibraryBooksBinding(materialCardView, textView, textView2, textView3, textView4, textView5, textView6, textView7, materialCardView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}