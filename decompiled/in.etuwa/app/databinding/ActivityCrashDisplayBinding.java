package in.etuwa.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import in.etuwa.app.R;

/* loaded from: classes3.dex */
public final class ActivityCrashDisplayBinding implements ViewBinding {
    public final Button btnClose;
    public final Button btnIgnore;
    public final Button btnReport;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView text2;
    public final TextView title;
    public final LinearLayout titleContainer;

    private ActivityCrashDisplayBinding(LinearLayout rootView, Button btnClose, Button btnIgnore, Button btnReport, TextView text, TextView text2, TextView title, LinearLayout titleContainer) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.btnIgnore = btnIgnore;
        this.btnReport = btnReport;
        this.text = text;
        this.text2 = text2;
        this.title = title;
        this.titleContainer = titleContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityCrashDisplayBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ActivityCrashDisplayBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.activity_crash_display, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityCrashDisplayBinding bind(View rootView) {
        int i = R.id.btnClose;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null) {
            i = R.id.btnIgnore;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null) {
                i = R.id.btnReport;
                Button button3 = (Button) ViewBindings.findChildViewById(rootView, i);
                if (button3 != null) {
                    i = R.id.text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.text2;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = android.R.id.title;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, android.R.id.title);
                            if (textView3 != null) {
                                LinearLayout linearLayout = (LinearLayout) rootView;
                                return new ActivityCrashDisplayBinding(linearLayout, button, button2, button3, textView, textView2, textView3, linearLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}