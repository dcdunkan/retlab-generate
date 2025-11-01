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
import in.etuwa.etlabstaff.ui.library.bookrecord.BookRecordViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentBooksRecordsBinding extends ViewDataBinding {
    public final LinearLayout inboxCoordinateLayout;

    @Bindable
    protected BookRecordViewModel mBookRecordViewModel;
    public final RecyclerView rvBooksRecords;

    public abstract void setBookRecordViewModel(BookRecordViewModel bookRecordViewModel);

    protected FragmentBooksRecordsBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout inboxCoordinateLayout, RecyclerView rvBooksRecords) {
        super(_bindingComponent, _root, _localFieldCount);
        this.inboxCoordinateLayout = inboxCoordinateLayout;
        this.rvBooksRecords = rvBooksRecords;
    }

    public BookRecordViewModel getBookRecordViewModel() {
        return this.mBookRecordViewModel;
    }

    public static FragmentBooksRecordsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksRecordsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentBooksRecordsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_books_records, root, attachToRoot, component);
    }

    public static FragmentBooksRecordsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksRecordsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentBooksRecordsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_books_records, null, false, component);
    }

    public static FragmentBooksRecordsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBooksRecordsBinding bind(View view, Object component) {
        return (FragmentBooksRecordsBinding) bind(component, view, R.layout.fragment_books_records);
    }
}