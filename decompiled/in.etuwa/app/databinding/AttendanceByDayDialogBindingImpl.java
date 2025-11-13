package in.etuwa.app.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.attendance.bydaynew.attendaceday.AttendanceDayDialogViewModel;

/* loaded from: classes3.dex */
public class AttendanceByDayDialogBindingImpl extends AttendanceByDayDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ScrollView mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.attandamce_byday_layout1, 1);
        sparseIntArray.put(R.id.date_title, 2);
        sparseIntArray.put(R.id.linearlt, 3);
        sparseIntArray.put(R.id.period1, 4);
        sparseIntArray.put(R.id.subject_name1, 5);
        sparseIntArray.put(R.id.linearcoverage1, 6);
        sparseIntArray.put(R.id.coverage1, 7);
        sparseIntArray.put(R.id.period2, 8);
        sparseIntArray.put(R.id.subject_name2, 9);
        sparseIntArray.put(R.id.linearcoverage2, 10);
        sparseIntArray.put(R.id.coverage2, 11);
        sparseIntArray.put(R.id.period3, 12);
        sparseIntArray.put(R.id.subject_name3, 13);
        sparseIntArray.put(R.id.linearcoverage3, 14);
        sparseIntArray.put(R.id.coverage3, 15);
        sparseIntArray.put(R.id.period4, 16);
        sparseIntArray.put(R.id.subject_name4, 17);
        sparseIntArray.put(R.id.linearcoverage4, 18);
        sparseIntArray.put(R.id.coverage4, 19);
        sparseIntArray.put(R.id.period5, 20);
        sparseIntArray.put(R.id.subject_name5, 21);
        sparseIntArray.put(R.id.linearcoverage5, 22);
        sparseIntArray.put(R.id.coverage5, 23);
        sparseIntArray.put(R.id.period6, 24);
        sparseIntArray.put(R.id.subject_name6, 25);
        sparseIntArray.put(R.id.linearcoverage6, 26);
        sparseIntArray.put(R.id.coverage6, 27);
        sparseIntArray.put(R.id.view1, 28);
        sparseIntArray.put(R.id.period7, 29);
        sparseIntArray.put(R.id.subject_name7, 30);
        sparseIntArray.put(R.id.linearcoverage7, 31);
        sparseIntArray.put(R.id.coverage7, 32);
        sparseIntArray.put(R.id.view2, 33);
        sparseIntArray.put(R.id.period8, 34);
        sparseIntArray.put(R.id.subject_name8, 35);
        sparseIntArray.put(R.id.linearcoverage8, 36);
        sparseIntArray.put(R.id.coverage8, 37);
        sparseIntArray.put(R.id.not_marked_text, 38);
    }

    public AttendanceByDayDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }

    private AttendanceByDayDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (TextView) bindings[7], (TextView) bindings[11], (TextView) bindings[15], (TextView) bindings[19], (TextView) bindings[23], (TextView) bindings[27], (TextView) bindings[32], (TextView) bindings[37], (TextView) bindings[2], (LinearLayout) bindings[6], (LinearLayout) bindings[10], (LinearLayout) bindings[14], (LinearLayout) bindings[18], (LinearLayout) bindings[22], (LinearLayout) bindings[26], (LinearLayout) bindings[31], (LinearLayout) bindings[36], (LinearLayout) bindings[3], (TextView) bindings[38], (TextView) bindings[4], (TextView) bindings[8], (TextView) bindings[12], (TextView) bindings[16], (TextView) bindings[20], (TextView) bindings[24], (TextView) bindings[29], (TextView) bindings[34], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[13], (TextView) bindings[17], (TextView) bindings[21], (TextView) bindings[25], (TextView) bindings[30], (TextView) bindings[35], (View) bindings[28], (View) bindings[33]);
        this.mDirtyFlags = -1L;
        ScrollView scrollView = (ScrollView) bindings[0];
        this.mboundView0 = scrollView;
        scrollView.setTag(null);
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
        if (36 != variableId) {
            return false;
        }
        setAttendanceDayDialogViewModel((AttendanceDayDialogViewModel) variable);
        return true;
    }

    @Override // in.etuwa.app.databinding.AttendanceByDayDialogBinding
    public void setAttendanceDayDialogViewModel(AttendanceDayDialogViewModel AttendanceDayDialogViewModel) {
        this.mAttendanceDayDialogViewModel = AttendanceDayDialogViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}