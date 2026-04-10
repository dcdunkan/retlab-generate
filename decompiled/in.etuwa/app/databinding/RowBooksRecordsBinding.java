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
public final class RowBooksRecordsBinding implements ViewBinding {
    public final TextView bookDueDate;
    public final TextView bookIssueDate;
    public final TextView bookNo;
    public final TextView bookTitle;
    public final TextView booksFine;
    public final TextView booksFineStatus;
    public final TextView booksRemarks;
    public final TextView booksRenewalDate;
    public final TextView booksReturnedDate;
    public final TextView booksStatus;
    public final MaterialCardView linearLibraryBooks;
    private final MaterialCardView rootView;

    private RowBooksRecordsBinding(MaterialCardView rootView, TextView bookDueDate, TextView bookIssueDate, TextView bookNo, TextView bookTitle, TextView booksFine, TextView booksFineStatus, TextView booksRemarks, TextView booksRenewalDate, TextView booksReturnedDate, TextView booksStatus, MaterialCardView linearLibraryBooks) {
        this.rootView = rootView;
        this.bookDueDate = bookDueDate;
        this.bookIssueDate = bookIssueDate;
        this.bookNo = bookNo;
        this.bookTitle = bookTitle;
        this.booksFine = booksFine;
        this.booksFineStatus = booksFineStatus;
        this.booksRemarks = booksRemarks;
        this.booksRenewalDate = booksRenewalDate;
        this.booksReturnedDate = booksReturnedDate;
        this.booksStatus = booksStatus;
        this.linearLibraryBooks = linearLibraryBooks;
    }

    @Override // androidx.viewbinding.ViewBinding
    public MaterialCardView getRoot() {
        return this.rootView;
    }

    public static RowBooksRecordsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RowBooksRecordsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.row_books_records, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RowBooksRecordsBinding bind(View rootView) {
        int i = R.id.book_due_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.book_issue_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.book_no;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.book_title;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.books_fine;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.books_fine_status;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.books_remarks;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.books_renewal_date;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView8 != null) {
                                        i = R.id.books_returned_date;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView9 != null) {
                                            i = R.id.books_status;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView10 != null) {
                                                MaterialCardView materialCardView = (MaterialCardView) rootView;
                                                return new RowBooksRecordsBinding(materialCardView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, materialCardView);
                                            }
                                        }
                                    }
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