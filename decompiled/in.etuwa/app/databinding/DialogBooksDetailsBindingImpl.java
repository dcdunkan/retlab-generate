package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.library.book.details.BookDetailsViewModel;

/* loaded from: classes3.dex */
public class DialogBooksDetailsBindingImpl extends DialogBooksDetailsBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final CardView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.book_title, 1);
        sparseIntArray.put(R.id.book_no, 2);
        sparseIntArray.put(R.id.book_id, 3);
        sparseIntArray.put(R.id.book_type, 4);
        sparseIntArray.put(R.id.arts_payable_lbl, 5);
        sparseIntArray.put(R.id.books_author, 6);
        sparseIntArray.put(R.id.books_category, 7);
        sparseIntArray.put(R.id.books_location, 8);
        sparseIntArray.put(R.id.books_status, 9);
        sparseIntArray.put(R.id.books_edition, 10);
        sparseIntArray.put(R.id.books_isbn, 11);
        sparseIntArray.put(R.id.books_distribution, 12);
    }

    public DialogBooksDetailsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private DialogBooksDetailsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[5], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[1], (TextView) bindings[4], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[12], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[8], (TextView) bindings[9]);
        this.mDirtyFlags = -1L;
        CardView cardView = (CardView) bindings[0];
        this.mboundView0 = cardView;
        cardView.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (42 != variableId) {
            return false;
        }
        setBooksDetailsViewModel((BookDetailsViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogBooksDetailsBinding
    public void setBooksDetailsViewModel(BookDetailsViewModel BooksDetailsViewModel) {
        this.mBooksDetailsViewModel = BooksDetailsViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}