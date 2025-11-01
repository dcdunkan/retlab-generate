package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import in.etuwa.app.R;
import in.etuwa.app.ui.fees.webview.fields.FieldsViewModel;

/* loaded from: classes3.dex */
public abstract class FragmentFieldsBinding extends ViewDataBinding {
    public final EditText distanceEt;
    public final TextView distanceTv;
    public final EditText etAadhaarNumber;
    public final EditText etMobileNumber;

    @Bindable
    protected FieldsViewModel mFieldsViewModel;
    public final TextView mobileNumberTv;
    public final EditText nameEt;
    public final TextView nameTv;
    public final TextView numberTv;
    public final EditText placeEt;
    public final TextView placeTv;
    public final TextView portTv;
    public final LinearLayout retypeAccLyt;
    public final Spinner spinnerPort;
    public final Spinner spinnerTon;
    public final Spinner spinnerVehicle;
    public final Spinner spinnerZone;
    public final TextView submitBtn;
    public final TextView tonTv;
    public final TextView typeTv;
    public final LinearLayout updateLyt;
    public final TextView zoneTv;

    public abstract void setFieldsViewModel(FieldsViewModel fieldsViewModel);

    protected FragmentFieldsBinding(Object _bindingComponent, View _root, int _localFieldCount, EditText distanceEt, TextView distanceTv, EditText etAadhaarNumber, EditText etMobileNumber, TextView mobileNumberTv, EditText nameEt, TextView nameTv, TextView numberTv, EditText placeEt, TextView placeTv, TextView portTv, LinearLayout retypeAccLyt, Spinner spinnerPort, Spinner spinnerTon, Spinner spinnerVehicle, Spinner spinnerZone, TextView submitBtn, TextView tonTv, TextView typeTv, LinearLayout updateLyt, TextView zoneTv) {
        super(_bindingComponent, _root, _localFieldCount);
        this.distanceEt = distanceEt;
        this.distanceTv = distanceTv;
        this.etAadhaarNumber = etAadhaarNumber;
        this.etMobileNumber = etMobileNumber;
        this.mobileNumberTv = mobileNumberTv;
        this.nameEt = nameEt;
        this.nameTv = nameTv;
        this.numberTv = numberTv;
        this.placeEt = placeEt;
        this.placeTv = placeTv;
        this.portTv = portTv;
        this.retypeAccLyt = retypeAccLyt;
        this.spinnerPort = spinnerPort;
        this.spinnerTon = spinnerTon;
        this.spinnerVehicle = spinnerVehicle;
        this.spinnerZone = spinnerZone;
        this.submitBtn = submitBtn;
        this.tonTv = tonTv;
        this.typeTv = typeTv;
        this.updateLyt = updateLyt;
        this.zoneTv = zoneTv;
    }

    public FieldsViewModel getFieldsViewModel() {
        return this.mFieldsViewModel;
    }

    public static FragmentFieldsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFieldsBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentFieldsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fields, root, attachToRoot, component);
    }

    public static FragmentFieldsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFieldsBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentFieldsBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_fields, null, false, component);
    }

    public static FragmentFieldsBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFieldsBinding bind(View view, Object component) {
        return (FragmentFieldsBinding) bind(component, view, R.layout.fragment_fields);
    }
}