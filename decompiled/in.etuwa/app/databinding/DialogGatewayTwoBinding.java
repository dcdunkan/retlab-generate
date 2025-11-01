package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.gateway2.GatewayTwoViewModel;

/* loaded from: classes3.dex */
public abstract class DialogGatewayTwoBinding extends ViewDataBinding {
    public final EditText accNoEt;
    public final TextView accNoTv;
    public final TextView bankNameTv;
    public final EditText branchEt;
    public final TextView branchNameTv;
    public final TextView editBtn;
    public final EditText end;
    public final TextView generateBtn;
    public final TextView ifscTv;

    @Bindable
    protected GatewayTwoViewModel mGatewayTwoViewModel;
    public final EditText nameEt;
    public final EditText noOfEntries;
    public final LinearLayout retypeAccLyt;
    public final EditText retypeAccNoEt;
    public final TextView retypeAccNoTv;
    public final EditText start;
    public final TextView updateBtn;
    public final LinearLayout updateLyt;

    public abstract void setGatewayTwoViewModel(GatewayTwoViewModel gatewayTwoViewModel);

    protected DialogGatewayTwoBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText accNoEt, TextView accNoTv, TextView bankNameTv, EditText branchEt, TextView branchNameTv, TextView editBtn, EditText end, TextView generateBtn, TextView ifscTv, EditText nameEt, EditText noOfEntries, LinearLayout retypeAccLyt, EditText retypeAccNoEt, TextView retypeAccNoTv, EditText start, TextView updateBtn, LinearLayout updateLyt) {
        super(_bindingComponent, _root, _localFieldCount);
        this.accNoEt = accNoEt;
        this.accNoTv = accNoTv;
        this.bankNameTv = bankNameTv;
        this.branchEt = branchEt;
        this.branchNameTv = branchNameTv;
        this.editBtn = editBtn;
        this.end = end;
        this.generateBtn = generateBtn;
        this.ifscTv = ifscTv;
        this.nameEt = nameEt;
        this.noOfEntries = noOfEntries;
        this.retypeAccLyt = retypeAccLyt;
        this.retypeAccNoEt = retypeAccNoEt;
        this.retypeAccNoTv = retypeAccNoTv;
        this.start = start;
        this.updateBtn = updateBtn;
        this.updateLyt = updateLyt;
    }

    public GatewayTwoViewModel getGatewayTwoViewModel() {
        return this.mGatewayTwoViewModel;
    }

    public static DialogGatewayTwoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGatewayTwoBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogGatewayTwoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_gateway_two, root, attachToRoot, component);
    }

    public static DialogGatewayTwoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGatewayTwoBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogGatewayTwoBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_gateway_two, null, false, component);
    }

    public static DialogGatewayTwoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogGatewayTwoBinding bind(View view, Object component) {
        return (DialogGatewayTwoBinding) bind(component, view, R.layout.dialog_gateway_two);
    }
}