package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import in.etuwa.app.R;
import in.etuwa.app.ui.hostel.mess.booknow.MessBookingViewModel;

/* loaded from: classes3.dex */
public class DialogMessBookingBindingImpl extends DialogMessBookingBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;
    private final FrameLayout mboundView1;
    private final ViewProgressBarBinding mboundView11;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.et_booking_date, 3);
        sparseIntArray.put(R.id.et_booking_day, 4);
        sparseIntArray.put(R.id.spinner_mess_menu, 5);
        sparseIntArray.put(R.id.spinner_mess_type, 6);
        sparseIntArray.put(R.id.mess_quantity, 7);
        sparseIntArray.put(R.id.max_qty_tv, 8);
        sparseIntArray.put(R.id.book_now_btn, 9);
        sparseIntArray.put(R.id.progress_view, 10);
        sparseIntArray.put(R.id.upload_progressbar, 11);
        sparseIntArray.put(R.id.progress_text, 12);
    }

    public DialogMessBookingBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private DialogMessBookingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[9], (TextInputEditText) bindings[3], (TextInputEditText) bindings[4], (TextView) bindings[8], (TextInputEditText) bindings[7], (TextView) bindings[12], (CardView) bindings[10], (Spinner) bindings[5], (Spinner) bindings[6], (ProgressBar) bindings[11]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
        FrameLayout frameLayout = (FrameLayout) bindings[1];
        this.mboundView1 = frameLayout;
        frameLayout.setTag(null);
        Object obj = bindings[2];
        this.mboundView11 = obj != null ? ViewProgressBarBinding.bind((View) obj) : null;
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
        if (139 != variableId) {
            return false;
        }
        setMessBookingViewModel((MessBookingViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.DialogMessBookingBinding
    public void setMessBookingViewModel(MessBookingViewModel MessBookingViewModel) {
        this.mMessBookingViewModel = MessBookingViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}