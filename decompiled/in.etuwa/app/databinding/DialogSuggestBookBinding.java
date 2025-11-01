package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import in.etuwa.app.R;
import in.etuwa.app.ui.library.suggest.SuggestBookViewModel;

/* loaded from: classes3.dex */
public abstract class DialogSuggestBookBinding extends ViewDataBinding {
    public final TextInputEditText etAuthor;
    public final TextInputEditText etEdition;
    public final TextInputEditText etIsbn;
    public final TextInputEditText etOtherDetails;
    public final TextInputEditText etPublication;
    public final TextInputEditText etTitle;

    @Bindable
    protected SuggestBookViewModel mSuggestBookViewModel;
    public final TextInputLayout reEnterAccEt;
    public final TextView suggestBtn;

    public abstract void setSuggestBookViewModel(SuggestBookViewModel suggestBookViewModel);

    protected DialogSuggestBookBinding(Object _bindingComponent, View _root, int _localFieldCount, TextInputEditText etAuthor, TextInputEditText etEdition, TextInputEditText etIsbn, TextInputEditText etOtherDetails, TextInputEditText etPublication, TextInputEditText etTitle, TextInputLayout reEnterAccEt, TextView suggestBtn) {
        super(_bindingComponent, _root, _localFieldCount);
        this.etAuthor = etAuthor;
        this.etEdition = etEdition;
        this.etIsbn = etIsbn;
        this.etOtherDetails = etOtherDetails;
        this.etPublication = etPublication;
        this.etTitle = etTitle;
        this.reEnterAccEt = reEnterAccEt;
        this.suggestBtn = suggestBtn;
    }

    public SuggestBookViewModel getSuggestBookViewModel() {
        return this.mSuggestBookViewModel;
    }

    public static DialogSuggestBookBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSuggestBookBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogSuggestBookBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_suggest_book, root, attachToRoot, component);
    }

    public static DialogSuggestBookBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSuggestBookBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogSuggestBookBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_suggest_book, null, false, component);
    }

    public static DialogSuggestBookBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogSuggestBookBinding bind(View view, Object component) {
        return (DialogSuggestBookBinding) bind(component, view, R.layout.dialog_suggest_book);
    }
}