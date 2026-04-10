package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* JADX INFO: loaded from: classes3.dex */
public final class FragmentLibraryBinding implements ViewBinding {
    public final TextView bookBtn;
    public final TextView bookRecordBtn;
    public final HorizontalScrollView hrView;
    public final LinearLayout mainLyt;
    private final FrameLayout rootView;
    public final RecyclerView rvBooks;
    public final RecyclerView rvBooksRecords;
    public final TextView suggestBtn;
    public final TextView toolbar;

    private FragmentLibraryBinding(FrameLayout rootView, TextView bookBtn, TextView bookRecordBtn, HorizontalScrollView hrView, LinearLayout mainLyt, RecyclerView rvBooks, RecyclerView rvBooksRecords, TextView suggestBtn, TextView toolbar) {
        this.rootView = rootView;
        this.bookBtn = bookBtn;
        this.bookRecordBtn = bookRecordBtn;
        this.hrView = hrView;
        this.mainLyt = mainLyt;
        this.rvBooks = rvBooks;
        this.rvBooksRecords = rvBooksRecords;
        this.suggestBtn = suggestBtn;
        this.toolbar = toolbar;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentLibraryBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentLibraryBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.fragment_library, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentLibraryBinding bind(View rootView) {
        int i = R.id.book_btn;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.book_record_btn;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.hr_view;
                HorizontalScrollView horizontalScrollView = (HorizontalScrollView) ViewBindings.findChildViewById(rootView, i);
                if (horizontalScrollView != null) {
                    i = R.id.main_lyt;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.rv_books;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            i = R.id.rv_books_records;
                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                            if (recyclerView2 != null) {
                                i = R.id.suggest_btn;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.toolbar;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        return new FragmentLibraryBinding((FrameLayout) rootView, textView, textView2, horizontalScrollView, linearLayout, recyclerView, recyclerView2, textView3, textView4);
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