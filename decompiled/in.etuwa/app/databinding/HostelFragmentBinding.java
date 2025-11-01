package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class HostelFragmentBinding implements ViewBinding {
    public final FloatingActionButton fabHostelFee;
    public final TextView hostJDate;
    public final TextView hostName;
    public final TextView hostRoom;
    public final RecyclerView recycFeerecip;
    private final FrameLayout rootView;

    private HostelFragmentBinding(FrameLayout rootView, FloatingActionButton fabHostelFee, TextView hostJDate, TextView hostName, TextView hostRoom, RecyclerView recycFeerecip) {
        this.rootView = rootView;
        this.fabHostelFee = fabHostelFee;
        this.hostJDate = hostJDate;
        this.hostName = hostName;
        this.hostRoom = hostRoom;
        this.recycFeerecip = recycFeerecip;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HostelFragmentBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HostelFragmentBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hostel_fragment, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HostelFragmentBinding bind(View rootView) {
        int i = R.id.fabHostelFee;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(rootView, i);
        if (floatingActionButton != null) {
            i = R.id.hostJDate;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.hostName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.hostRoom;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.recyc_feerecip;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                        if (recyclerView != null) {
                            return new HostelFragmentBinding((FrameLayout) rootView, floatingActionButton, textView, textView2, textView3, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}